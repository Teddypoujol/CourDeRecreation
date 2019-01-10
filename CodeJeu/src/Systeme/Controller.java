package Systeme;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Acteur.*;

import Systeme.*;


public class Controller 
{
	/*
	 * Les listes de éléments du jeu et des éléments à supprimer
	 */
	
	private static Controller INSTANCE;
	/*
	 * Liste des élèves
	 */
	private List<Eleve> eleves;
	
	/*
	 * Liste des professeurs
	 */
	private List<Professeur> professeurs;
	
	/*
	 * Liste des professeurs et des élèves qui ne doivent plus être en jeu
	 */
	private List<Eleve> elevesexclus;
	private List<Professeur> profenburnout;
	
	/*
	private List<ElementdeJeu> buffer;
	
	private Window window;
	private Map map;
	*/
	private Grille grille;
	/*
	 * nombres de professeurs et d'élèves dans le jeu
	 */
	
	private int nb_Professeurs;
	private int nb_Eleves;

	/*
	 * Ces variabes booléennes permettent de connaitre l'état du jeu. 
	 */
	
	private boolean inter = false;
	private boolean gameInited;
	private boolean gameStarted;
	private boolean gameover;
	
	private Random random = new Random();
	
	private Controller() 
	{
	}
	
	/*
	 * Singleton
	 */
	public static Controller getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Controller();
			INSTANCE.gameInited = false;
		}
		return INSTANCE;
	}

	/*
	 * Getteurs des Listes des éléments du jeu
	 */
	public List<Eleve> getEleves() 
	{
		return this.eleves;
	}

	public List<Professeur> getProfesseurs() 
	{
		return this.professeurs;
	}

	public List<Eleve> getElevesExclu() {
		return this.elevesexclus;
	}

	public List<Professeur> getProfenburnout() {
		return this.profenburnout;
	}

	
	public Grille getGrille() 
	{
		return this.grille;
	}
	/*public Window getWindow() 
	{
		return window;
	}
	public Map getMap() 
	{
		return map;
	}*/
	
	
	/*
	 * permet de verifier si l'interface est en cours d'utilisation par le controller
	 */
	public boolean isIhm() 
	{
		return inter;
	}

	public void setIhm(boolean ihm)
	{
		this.inter = ihm;
	}
	
	/*
	 * Setteurs qui permettent de choisir le nombre de professeurs et d'élèves en jeu
	 */
	public void setNbProf(int nombredeprof) 
	{
		this.nb_Professeurs = nombredeprof ;
	}

	public void setNbEleves(int nombreEleve) 
	{
		this.nb_Eleves = nombreEleve ;
	}
	
	
	/*
	 * Ces méthodes permettent de connaitre l'état du jeu. 
	 */

	public boolean gameIsInit() {
		return gameInited;
	}

	public void setGameInited(boolean gameStarted) {
		this.gameInited = gameStarted;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}

	public boolean gameOver() {
		return this.gameover;
	}
	
	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}
	
	
	public ArrayList<String> listeNomEleve = new ArrayList<String>(Arrays.asList(
			"Teddy","Clara", "Loic","Jerome","GoGo","Imane","Mayol","Mathilde","Remi","Manon","Thomas","Mathieu",
			"Romain","Alexis","Pantoufle","Micka","Jule","Popito","Bernard","Julie","Juan","Pankake","Arthur","Marius",
			"Aurelien"));
	
	public ArrayList<String> listeNomProf = new ArrayList<String>(Arrays.asList(
			"Mr Quafafou","Mr Prosperi", "Mr Mavromatis","Mme Papini","Mme Bac","Mr Samuel","Mr Bonnecaze","Mr Banton"));
	
	
	
	/**
	 * Faire apparaitre un éléve sur la grille
	 * 
	 * @param li 	indice de ligne de la Grid ou faire apparaitre l'élève.
	 * @param co 	indice de colonne de la Grid ou faire apparaitre l'élève.
	 */
	public void PlacerEleve(int li, int co) 
	{
		if(0 <= li && li < Constant.getMapHeight() && 0 <= co && co < Constant.getMapWidth()) 
		{
			int porteerand = new Random().nextInt(2) + 1;
			Eleve eleve;
			eleve = new Eleve(listeNomEleve.get(0),porteerand, li, co);
			listeNomEleve.remove(0);
			this.eleves.add((Eleve)eleve);
			this.grille.getCells()[li][co].setContent(eleve);
		}	
	}
		
	public void PlacerProfesseur(int li, int co) 
	{
		
		if(0 <= li && li < Constant.getMapHeight() && 0 <= co && co < Constant.getMapWidth()) 
		{
			int ancienneterand = new Random().nextInt(10);
			Professeur prof;
			prof = new Professeur(listeNomProf.get(0), ancienneterand, li, co); 
			this.professeurs.add((Professeur)prof);
			this.grille.getCells()[li][co].setContent(prof);
				
		}
		
	}
	
	public void PlacerEleveTurbulent(int li, int co) 
	{
		
		if(0 <= li && li < Constant.getMapHeight() && 0 <= co && co < Constant.getMapWidth()) 
		{
			int porteerand = new Random().nextInt(2) + 1;
			EleveTurbulent eleve;
			eleve = new EleveTurbulent();
			this.eleves.add((EleveTurbulent)eleve);
			this.grille.getCells()[li][co].setContent(eleve);
				
		}
		
	}

	/**
	 * Exclus l'élève de l'école. Necessite une MAJ des listes d'élèves en fonction 
	 * des éléves exlus.
	 * 
	 * @param eleve l'éleve à exclure.
	 */
	public void exclure(Eleve eleve)
	{
		this.elevesexclus.add(eleve);
		int li = eleve.getPosX();
		int co = eleve.getPosY();
		this.grille.getCells()[li][co].setContent(new Terrain(li, co));
	}

	/**
	 * Enleve le professeur qui a fait un burnout.
	 * 
	 * @param c la Carrot qui a ete consommee.
	 */
	public void Burnout(Professeur prof) 
	{
		this.profenburnout.add(prof);
	}


	


}