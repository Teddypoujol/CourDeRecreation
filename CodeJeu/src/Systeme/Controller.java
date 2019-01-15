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
import Interface.Map;
import Interface.Fenetre;


public class Controller 
{
	/*
	 * Les listes de éléments du jeu et des éléments à supprimer
	 */
	
	private static Controller INSTANCE;
	/*
	 * Liste des élèves
	 */
	private int indiceListeEleves = 0;
	private List<Eleve> eleves;
	private List<EleveTurbulent> elevesT;
	/*
	 * Liste des professeurs
	 */
	private List<Professeur> professeurs;
	
	/*
	 * Liste des professeurs et des élèves qui ne doivent plus être en jeu
	 */
	private List<Eleve> elevesexclus;
	private List<Professeur> profenburnout;
	
	
	private List<ElementdeJeu> buffer;
	
	private Fenetre fenetre;
	private Map map;
	
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
	
	public List<EleveTurbulent> getElevesT() 
	{
		return this.elevesT;
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
	
	public Fenetre getFenetre() 
	{
		return fenetre;
	}
	public Map getMap() 
	{
		return map;
	}
	
	
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
	
	public void setNbElevesT(int nombreEleve) 
	{
		this.nb_ElevesTurbulents = nombreEleve ;
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
			"Mr Quafafou","Mr Prosperi", "Mr Mavromatis","Mme Papini","Mme Bac","Mr Samuel","Mr Bonnecaze","Mr Banton","Mr Gengler","Mr Mugmug"));
	
	public ArrayList<String> listeNomEleveT = new ArrayList<String>(Arrays.asList(
			"TURBULENT","Maxime", "turbu3","turbu4","turbu5","turbu6"));
	
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
			listeNomProf.remove(0);
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
			eleve = new EleveTurbulent(listeNomEleveT.get(0),porteerand, li, co,bagarreur.nextBoolean());
			listeNomEleveT.remove(0);
			this.elevesT.add((EleveTurbulent)eleve);
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
		eleves.remove(eleve);
	}
	

	/**
	 * Enleve le professeur qui a fait un burnout.
	 * 
	 * @param prof le prof en burnout
	 */
	
	public void burnout(Professeur prof) 
	{
		this.profenburnout.add(prof);
		int li = prof.getPosX();
		int co = prof.getPosY();
		this.grille.getCells()[li][co].setContent(new Terrain(li, co));
		professeurs.remove(prof);
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
		this.elevesT = new ArrayList<>();
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
				if(((nb = this.inputNumber("professeurs")) > nbMaxProf)) 
				{
					System.out.println("Le nombre max de professeurs est de 10");
				}
			} while(nb > nbMaxEleve);
			
		
			
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

			
			
			do 
			{
				if(((nb = this.inputNumber("elevesT")) > 10)) 
				{
					System.out.println("Le nombre max d'élèves turbulent est limité à 10 dans la cour");
				}
			} while(nb > 10);
			
			
			for(int i = 0; i < nb; i++) 
			{
				placed = false;
				do {
					posRandomx = this.random.nextInt(this.grille.getLi());
					posRandomy = this.random.nextInt(this.grille.getCo());
					if(this.grille.getCells()[posRandomx][posRandomy].isEmpty()) 
					{
						this.placerEleveTurbulent(posRandomx, posRandomy);
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
			int w = screenSize.width;
			int h = screenSize.height;
			this.fenetre = new Fenetre(w,h);
			this.map = new Map();
			this.fenetre.add(this.map);
			
			
			
		}
	}
	
	/**
	 * Recherche Professeur autour d'un élève
	 */
	
	public ArrayList<Professeur> rechercheProf(Eleve e)
	{
		ArrayList<Professeur> prof = new ArrayList<>();
		int x = e.getPosX();
		int y = e.getPosY();
		int xtmp = x;
		int ytmp = y;
		Cell c = Controller.getInstance().getGrille().getCells()[x][y];	
		
		int visibilite = 5;
		
		//parcour haut
		while(!c.getContent().getClass().getName().equals("Acteur.Professeur") && xtmp>x-visibilite && xtmp>0) {
			xtmp--; 
			c = Controller.getInstance().getGrille().getCells()[xtmp][y];
		}
		if(c.getContent().getClass().getName().equals("Acteur.Professeur")) 
		{
			prof.add((Professeur)c.getContent());		
		}
		//parcour bas
		xtmp = x;
		ytmp = y;
		c = Controller.getInstance().getGrille().getCells()[x][y];	
		while(!c.getContent().getClass().getName().equals("Acteur.Professeur") && xtmp<x+visibilite && xtmp < Constant.getMapHeight()-1) {
			xtmp++; 
			c = Controller.getInstance().getGrille().getCells()[xtmp][y];
		}
		if(c.getContent().getClass().getName().equals("Acteur.Professeur")) 
		{
			prof.add((Professeur)c.getContent());
		}
		//parcour gauche
		xtmp = x;
		ytmp = y;
		c = Controller.getInstance().getGrille().getCells()[x][y];	
		while(!c.getContent().getClass().getName().equals("Acteur.Professeur") && ytmp>y-visibilite && ytmp>0) {
			ytmp--; 
			c = Controller.getInstance().getGrille().getCells()[x][ytmp];
		}
		if(c.getContent().getClass().getName().equals("Acteur.Professeur")) 
		{
			prof.add((Professeur)c.getContent());
		}
		//parcour droite
		xtmp = x;
		ytmp = y;
		c = Controller.getInstance().getGrille().getCells()[x][y];	
		while(!c.getContent().getClass().getName().equals("Acteur.Professeur") && ytmp<y+visibilite && ytmp < Constant.getMapWidth()-1) {
			ytmp++; 
			c = Controller.getInstance().getGrille().getCells()[x][ytmp];
		}
		if(c.getContent().getClass().getName().equals("Acteur.Professeur")) 
		{
			prof.add((Professeur)c.getContent());
		}
		return prof;
	}
	
	
	/**
	 * Traitement de l'action choisie
	 */
	
	public void traitementAction(Eleve e,int action) {
		ArrayList<Professeur> prof = rechercheProf(e);
			
		if(!prof.isEmpty())
		{
			if(action == 0) e.majPunition();
			for(Professeur p : prof) 
			{
				p.majPatience(action);
				if(p.verifPatience())
				{
					burnout(p);
				}
			}
		}
	}
		
	/**
	 * Passe un tour de jeu et actualise la Grille en consequence.
	
	 */
	
	public void tourSuivant() throws InterruptedException 
	{
		
		ArrayList<Eleve> elevestmp = new ArrayList<>();
		
		elevestmp.addAll(this.eleves);
		elevestmp.addAll(this.elevesT);
		
		if(!elevestmp.isEmpty() && !professeurs.isEmpty()) 
		{
			
			Eleve tmp = elevestmp.get(indiceListeEleves);
			indiceListeEleves = (indiceListeEleves + 1)%elevestmp.size();
			int x = tmp.getPosX();
			int y = tmp.getPosY();
			this.grille.getCells()[x][y].setContent(new Terrain(x, y));
			Cell direction = tmp.deplacement();
			
			
			if(!tmp.verifPunition()) 
			{
				ElementdeJeu content = direction.getContent();
				direction.setContent(tmp);
				ArrayList<ElementdeJeu> elevesA = new ArrayList<>();
				
				//haut
				
				if(x>0 && this.grille.getCells()[x-1][y].getContent().getClass().getName().equals("Acteur.Eleve")) {
					elevesA.add(this.grille.getCells()[x-1][y].getContent());				
				}
				//bas
				if(x<Constant.getMapHeight()-1 && this.grille.getCells()[x+1][y].getContent().getClass().getName().equals("Acteur.Eleve")) {
					elevesA.add(this.grille.getCells()[x+1][y].getContent());					
				}
				//gauche
				if(y>0 && this.grille.getCells()[x][y-1].getContent().getClass().getName().equals("Acteur.Eleve")) {
					elevesA.add(this.grille.getCells()[x][y-1].getContent());
				}
				//droite
				if(y<Constant.getMapWidth()-1 && this.grille.getCells()[x][y+1].getContent().getClass().getName().equals("Acteur.Eleve")) {
					elevesA.add(this.grille.getCells()[x][y+1].getContent());					
				}
				
				if(!elevesA.isEmpty()) 
				{
					int action =tmp.choisirAction();
					traitementAction(tmp,action);
				}
					
			}
			else
			{
				exclure(tmp);
			}
			/*
			if(this.inter) 
			{
				this.fenetre.repaint();
				Thread.sleep(500);
			}
			*/
			//this.buffer.clear();

			if(this.inter) {
				this.map.repaint();
			} else 
			{
				this.grille.display();	
			}
			
		}
	
		else 
		{
			this.gameover = true;
			if(this.inter)
			{
				this.map.repaint();
			}
		}
		
			
			
		
	
		
	} 
}


	
	

	



