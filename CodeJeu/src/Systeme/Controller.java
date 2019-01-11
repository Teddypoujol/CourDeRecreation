package Systeme;

import java.util.List;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private Random random = new Random();
	private Grille grille;
	
	/*
	 * nombres de professeurs et d'élèves dans le jeu
	 */
	
	private int nb_Professeurs;
	private int nb_Eleves;
	private int nb_ElevesTurbulents;
	
	private static int nbMaxEleve = 40;
	private static int nbMaxProf = 10;
	/*
	 * Ces variabes booléennes permettent de connaitre l'état du jeu. 
	 */
	
	private boolean inter = false;
	private boolean gameInited;
	private boolean gameStarted;
	private boolean gameover;
	
	/*
	 * Constructeur par défaut 
	 */
	private Controller() 
	{
	}
	
	/*
	 * Singleton permet d'avoir une seule instance de controller créée et que controller soit accessible par tous
	 */
	
	public static Controller getInstance() 
	{
		if(INSTANCE == null) 
		{
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

	public List<Eleve> getElevesExclu()
	{
		return this.elevesexclus;
	}

	public List<Professeur> getProfenburnout() 
	{
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
	
	
	
	/*
	 * Listes des noms des élèves et des professeurs
	 */
	
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
	
	public void placerEleve(int li, int co) 
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
	
	
	/**
	 * Faire apparaitre un professeur sur la grille
	 * 
	 * @param li 	indice de ligne de la Grid ou faire apparaitre le professeur.
	 * @param co 	indice de colonne de la Grid ou faire apparaitre le professeur.
	 */
	
	public void placerProfesseur(int li, int co) 
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
	
	/**
	 * Faire apparaitre un élève turbulent sur la grille
	 * 
	 * @param li 	indice de ligne de la Grid ou faire apparaitre l'élève.
	 * @param co 	indice de colonne de la Grid ou faire apparaitre l'élève.
	 */
	
	public void placerEleveTurbulent(int li, int co) 
	{
		
		if(0 <= li && li < Constant.getMapHeight() && 0 <= co && co < Constant.getMapWidth()) 
		{
			Random bagarreur = new Random();
		    
		    
			int porteerand = new Random().nextInt(2) + 1;
			EleveTurbulent eleve;
			eleve = new EleveTurbulent(listeNomEleve.get(0),porteerand, li, co,bagarreur.nextBoolean());
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
	 * @param prof le prof en burnout
	 */
	
	public void Burnout(Professeur prof) 
	{
		this.profenburnout.add(prof);
		int li = prof.getPosX();
		int co = prof.getPosY();
		this.grille.getCells()[li][co].setContent(new Terrain(li, co));
	}

	
	
	

	
	/**
	 * Renvoie l'entier naturel correspondant a la valeur numerique representee 
	 * par la Srting passee en parametre.
	 * 
	 * @param str 	String convertie.
	 * @return 		un entier naturel correspondant a la valeur numerique representee par str 
	 * 				ou -1 si la String n'en represente pas un.
	 */
	
	public int unsigned(String str) 
	{
		try 
		{
			return Integer.parseInt(str);
		} catch(NumberFormatException nfe) 
		{
			return -1;
		}
	}

	/**
	 * Invite l'utilisateur a saisir dans le terminal, une valeur entiere positive qui representera 
	 * le nombre d'acteur du type renseigne par la String passee en parametre (utilise unsigned()).
	 * 
	 * @param actor String informant pour quel acteur l'utilisateur est en train de saisir le nombre.
	 * @return 		le nombre saisi si c'est un entier naturel, -1 sinon.
	 */
	
	private int inputNumber(String actor) throws IOException 
	{
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Mettre le nombre de " + actor + " : ");

		int choix;
		do {
			choix = unsigned(bufferReader.readLine());
			if(choix < 0) 
			{
				System.out.println("Error, unsigned expected");
			}
		} while(choix < 0);

		return choix;
	}

	
	
	
	
	public void init(boolean ihm) throws IOException 
	{
		this.inter = ihm;
		this.gameover = false;
		this.grille = new Grille(Constant.getMapWidth(), Constant.getMapHeight());
		
		this.eleves = new ArrayList<>();
		this.professeurs = new ArrayList<>();
		this.profenburnout = new ArrayList<>();
		this.elevesexclus = new ArrayList<>();
		
		//this.underground = new ArrayList<>();
		//this.buffer = new ArrayList<>();

		int posRandomx;
		int posRandomy;
		int nb;
		boolean placed;
		//int spaceLeft = Constant.getMapWidth() * Constant.getMapHeight();
		
		if(!inter) 
		{
			do 
			{
				if(((nb = this.inputNumber("eleves")) > nbMaxEleve)) 
				{
					System.out.println("Le nombre max d'élèves est limité à 40 dans la cour");
				}
			} while(nb > nbMaxEleve);
			
		
			//spaceLeft -= nb;
			
			for(int i = 0; i < nb; i++) 
			{
				placed = false;
				do {
					posRandomx = this.random.nextInt(this.grille.getLi());
					posRandomy = this.random.nextInt(this.grille.getCo());
					if(this.grille.getCells()[posRandomx][posRandomy].isEmpty()) 
					{
						this.placerEleve(posRandomx, posRandomy);
						placed = true;
					}
				} while(!placed);
			}

			do 
			{
				if(((nb = this.inputNumber("professeurs")) > nbMaxEleve)) 
				{
					System.out.println("Le nombre max d'élèves est limité à 40 dans la cour");
				}
			} while(nb > nbMaxEleve);
			
			
			//spaceLeft -= nb;
			
			for(int i = 0; i < nb; i++) 
			{
				placed = false;
				do {
					posRandomx = this.random.nextInt(this.grille.getLi());
					posRandomy = this.random.nextInt(this.grille.getCo());
					if(this.grille.getCells()[posRandomx][posRandomy].isEmpty())
					{
						this.placerProfesseur(posRandomx, posRandomy);
						placed = true;
					}
				} while(!placed);
			}

	
			this.grille.display();
		
		} 
		else 
		{
			for(int i = 0; i < nb_Eleves; i++) 
			{
				placed = false;
				do {
					posRandomx = this.random.nextInt(this.grille.getLi());
					posRandomy= this.random.nextInt(this.grille.getCo());
					if(this.grille.getCells()[posRandomx][posRandomy].isEmpty()) 
					{
						this.placerEleve(posRandomx,posRandomy);
						placed = true;
					}
				} while(!placed);
			}

			for(int i = 0; i < nb_Professeurs; i++) 
			{
				placed = false;
				do {
					posRandomx = this.random.nextInt(this.grille.getLi());
					posRandomy = this.random.nextInt(this.grille.getCo());
					if(this.grille.getCells()[posRandomx][posRandomy].isEmpty()) 
					{
						this.placerProfesseur(posRandomx,posRandomy);
						placed = true;
					}
				} while(!placed);
			}

			for(int i = 0; i < nb_ElevesTurbulents; i++) 
			{
				placed = false;
				do {
					posRandomx = this.random.nextInt(this.grille.getLi());
					posRandomy = this.random.nextInt(this.grille.getCo());
					if (this.grille.getCells()[posRandomx][posRandomy].isEmpty()) 
					{
						this.placerEleveTurbulent(posRandomx,posRandomy);
						placed = true;
					}
				} while(!placed);
			}

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			/*
			this.window = new Window(screenSize.width, screenSize.height);
			this.map = new Map();
			this.window.add(this.map);
			*/
		}
		
	}

	
	

	


}
