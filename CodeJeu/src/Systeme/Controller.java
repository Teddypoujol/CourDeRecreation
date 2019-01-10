package Systeme;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import Acteur.Eleve;
import Acteur.Professeur;
import Acteur.Personne;

import Systeme.*;
// test de merde

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
	private Grid grid;
	private Window window;
	private Map map;
	*/
	
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

	/*
	public Grid getGrid() 
	{
		return this.grid;
	}

	public Window getWindow() 
	{
		return window;
	}

	public Map getMap() 
	{
		return map;
	}
	*/
	
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
			Random rd = new Random();
			Acteur.Eleve eleve;
			eleve = new Eleve();
			this.eleves.add((Eleve)eleve);
			this.grid.getCells()[li][co].setContent(eleve);
		}	
	}
		
	public void PlacerProfesseur(int li, int co) 
	{
		if(0 <= li && li < Constant.getMapHeight() && 0 <= co && co < Constant.getMapWidth()) 
		{
			int rand = new Random().nextInt(3);
			Professeur prof;
			prof = new prof();
			this.professeurs.add((Professeur)prof);
			this.grid.getCells()[li][co].setContent(prof);
				
		}
	}
	
	public void PlacerCas
	{
		if(0 <= li && li < Constant.getMapHeight() && 0 <= co && co < Constant.getMapWidth()) 
		{
			int rand = new Random().nextInt(3);
			Professeur prof;
			prof = new prof();
			this.professeurs.add((Professeur)prof);
			this.grid.getCells()[li][co].setContent(prof);
				
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
		int li = eleve.getPosLi();
		int co = eleve.getPosCo();
		this.grid.getCells()[li][co].setContent(new terrain(li, co));
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
