package Systeme;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Acteur.*;
import Interface.*;

/**
 * Le controller est l'element principal du jeu, c'est lui qui initialise la cour de
 * recreation et ses elements, il permet l'interaction entre les differents objets du projet.
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Tileset
 * @version 2.0
 */


public class Controller 
{
	/**
	 * Les listes de elements du jeu et des elements a supprimer
	 */
	
	private static Controller INSTANCE;
	/**
	 * Liste des elèves
	 */
	private int indiceListeEleves = 0;
	private List<Eleve> eleves;
	private List<EleveTurbulent> elevesT;
	/**
	 * Liste des professeurs
	 */
	private List<Professeur> professeurs;
	
	/**
	 * Liste des professeurs et des elèves qui ne doivent plus être en jeu
	 */
	private List<Eleve> elevesexclus;
	private List<Professeur> profenburnout;
	
	private Fenetre fenetre;
	private Fenetre fenetre2;

	private Map map;
	private ConsolePanneau con;
	
	
	private Random random = new Random();
	private Grille grille;
	
	/**
	 * nombre de professeurs dans le jeu
	 */
	
	private int nb_Professeurs;
	
	/**
	 * nombre  d'elèves dans le jeu
	 */ 
	private int nb_Eleves;
	
	/**
	 * nombre  d'elèves Turbulents dans le jeu
	 */ 
	private int nb_ElevesTurbulents;
	
	/**
	 * nombre maximum d'elèves  dans le jeu
	 */ 
	private static int nbMaxEleve = 40;
	/**
	 * nombre maximum de professeurs dans le jeu
	 */ 
	private static int nbMaxProf = 10;
	/**
	 * Ces variabes booleennes permettent de connaitre l'etat du jeu. 
	 */
	
	private boolean inter = false;
	private boolean gameInited;
	private boolean gameStarted;
	private boolean gameover;
	
	/**
	 * Constructeur par defaut 
	 */
	private Controller() 
	{
	}
	
	/**
	 * Singleton permet d'avoir une seule instance de controller creee et que controller soit accessible par tous
	 * @return INSTANCE
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

	/**
	 * Getteurs de la liste des eleves
	 *  @return eleves
	 */
	
	public List<Eleve> getEleves() 
	{
		return this.eleves;
	}
	
	/**
	 * Getteurs de la liste des professeurs
	 *  @return professeurs
	 */

	public List<Professeur> getProfesseurs() 
	{
		return this.professeurs;
	}
	
	/**
	 * Getteurs de la liste des eleves turbulents
	 *  @return elevesT
	 */

	public List<EleveTurbulent> getElevesT() 
	{
		return this.elevesT;
	}

	/**
	 * Getteurs de la liste des eleves exclus
	 *  @return elevesexclus
	 */
	public List<Eleve> getElevesExclu()
	{
		return this.elevesexclus;
	}
	
	/**
	 * Getteurs de la liste des profs en burn out
	 *  @return profenburnout
	 */
	public List<Professeur> getProfenburnout() 
	{
		return this.profenburnout;
	}
	
	/**
	 * Getteurs de la grille
	 *  @return grille
	 */
	
	public Grille getGrille() 
	{
		return this.grille;
	}
	
	/**
	 * Getteurs de la fenetre
	 *  @return fenetre
	 */
	
	public Fenetre getFenetre() 
	{
		return fenetre;
	}
	
	/**
	 * Getteurs de la map
	 *  @return map
	 */
	
	public Map getMap() 
	{
		return map;
	}
	
	
	/**
	 * permet de verifier si l'interface est en cours d'utilisation par le controller
	 * @return inter
	 */
	public boolean isIhm() 
	{
		return inter;
	}
	
	/**
	 * permet de dire au système que l'interface est en cours d'utilisation par le controller
	 * @param ihm booleen qui modifie ihm
	 * @return si l'interface est utilisee ou non inter
	 */

	public void setIhm(boolean ihm)
	{
		this.inter = ihm;
	}
	
	/*
	 * Setteurs qui permettent de choisir le nombre de professeurs et d'elèves en jeu
	 */
	
	/**
	 * Modifie le nombre de professeurs
	 * @param nombredeprof modifie nb profs
	 */
	public void setNbProf(int nombredeprof) 
	{
		this.nb_Professeurs = nombredeprof ;
	}
	
	/**
	 * Modifie le nombre d'elèves
	 * @param nombreEleve modifie nb_Eleves
	 */
	public void setNbEleves(int nombreEleve) 
	{
		this.nb_Eleves = nombreEleve ;
	}
	/**
	 * Modifie le nombre d'elèves turbulents
	 * @param nombreEleve modifie nb_ElevesT
	 */
	public void setNbElevesT(int nombreEleve) 
	{
		this.nb_ElevesTurbulents = nombreEleve ;
	}
	/*
	 * Ces methodes permettent de connaitre l'etat du jeu. 
	 */
	/**
	 * permet de savoir si le jeu est initialise
	 * @return gameInited un booleen 
	 */
	
	public boolean gameIsInit() {
		return gameInited;
	}
	
	/**
	 * Permet d'initialiser le jeu
	 * @param gameStarted
	 * @return Change game Inited par gameStarted
	 */

	public void setGameInited(boolean gameStarted) {
		this.gameInited = gameStarted;
	}

	
	/**
	 * Permet de savoir si le jeu est lance
	 * @param gameStarted
	 * @return Change game Inited par gameStarted
	 */
	public boolean isGameStarted() {
		return gameStarted;
	}

	/**
	 * Permet de lancer le jeu ou l'arreter
	 * @param gameStarted
	 * @return Change game gameStarted par gameStarted
	 */
	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}
	
	/**
	 * Permet de savoir quand le jeu termine
	 * @return booleen game over
	 */
	public boolean gameOver() {
		return this.gameover;
	}
	
	/**
	 * Permet de modifier le booleen gameover
	 */
	
	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}
	
	
	
	/**
	 * Listes des noms des elèves
	 */
	
	public ArrayList<String> listeNomEleve = new ArrayList<String>(Arrays.asList(
			"Teddy","Clara", "Loic","Jerome","GoGo","Imane","Mayol","Mathilde","Remi","Manon","Thomas","Mathieu",
			"Romain","Alexis","Pantoufle","Micka","Jule","Popito","Bernard","Julie","Juan","Pankake","Arthur","Marius",
			"Aurelien"));
	/**
	 * Listes des noms des professeurs
	 */
	public ArrayList<String> listeNomProf = new ArrayList<String>(Arrays.asList(
			"Mr Quafafou","Mr Prosperi", "Mr Mavromatis","Mme Papini","Mme Bac","Mr Samuel","Mr Bonnecaze","Mr Banton","Mr Gengler","Mr Mugmug"));
	
	/**
	 * Listes des noms des elèves turbulents
	 */
	public ArrayList<String> listeNomEleveT = new ArrayList<String>(Arrays.asList(
			"TURBULENT","Maxime", "turbu3","turbu4","turbu5","turbu6"));
	
	/**
	 * Faire apparaitre un eleve sur la grille
	 * 
	 * @param li 	indice de ligne de la Grid ou faire apparaitre l'elève.
	 * @param co 	indice de colonne de la Grid ou faire apparaitre l'elève.
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
	 * Faire apparaitre un elève turbulent sur la grille
	 * 
	 * @param li 	indice de ligne de la Grid ou faire apparaitre l'elève.
	 * @param co 	indice de colonne de la Grid ou faire apparaitre l'elève.
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
	 * Exclus l'elève de l'ecole. Necessite une MAJ des listes d'elèves en fonction 
	 * des eleves exlus.
	 * 
	 * @param eleve l'eleve a exclure.
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

	
	
	
	/**
	 * Initialise la map en plaçant aleatoirement les elèves et les professeurs
	 * @param ihm qui permet de lancer l'interface
	 */
	
	public void init(boolean ihm) throws IOException 
	{
		this.inter = ihm;
		this.gameover = false;
		this.grille = new Grille(Constant.getMapHeight(),Constant.getMapWidth() );
		
		this.eleves = new ArrayList<>();
		this.elevesT = new ArrayList<>();
		this.professeurs = new ArrayList<>();
		this.profenburnout = new ArrayList<>();
		this.elevesexclus = new ArrayList<>();
		

		int posRandomx;
		int posRandomy;
		int nb;
		boolean placed;
		
		//placerEleve(0,1);
		
		if(!inter) 
		{
			do 
			{
				if(((nb = this.inputNumber("eleves")) > nbMaxEleve)) 
				{
					System.out.println("Le nombre max d'elèves est limite a 40 dans la cour");
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
					System.out.println("Le nombre max d'elèves turbulent est limite a 10 dans la cour");
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

			
			int w = 60*20;
			int h = 60*10+28;
			this.fenetre = new Fenetre(w,h);
			//this.fenetre2 = new Fenetre(200,200);
			this.fenetre.setLayout(new BorderLayout());
			this.map = new Map();
			//this.con = new ConsolePanneau();
			/*
			GridLayout gl = new GridLayout(4,1);
			this.setLayout(gl);
			gl.setHgap(40);
			gl.setVgap(50);
			*/
			
			this.fenetre.add(this.map,BorderLayout.CENTER);
			
			
			
		}
	}
	
	/**
	 * Recherche d'un Professeur autour d'un elève
	 * si il y a un professeur proche de l'elève qui effectue l'action les consequences ne seront pas les mêmes pour 
	 * le professeurs et pour l'elève en question.
	 * @param e un elève 
	 * @return liste de professeurs
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
	 * On utilise rechercheProf() qui nous permet de recuperer la liste des professeurs proche le l'elève
	 * et si il y a une bagarre, l'elève est punis et on met a jour la patience du professeur.
	 * @param e Eleve vise 
	 * @param action l'action de l'elève
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
	* on verifie si les listes ne sont pas nulles et si des elèves doivent être exlus ou
	* si des professeurs partent en burn out. puis les elèves se deplacent.
	 */
	
	public void tourSuivant() throws InterruptedException 
	{
		
		ArrayList<Eleve> elevestmp = new ArrayList<>();
		
		elevestmp.addAll(this.eleves);
		elevestmp.addAll(this.elevesT);
		
		if(!elevestmp.isEmpty() && !professeurs.isEmpty()) 
		{
			for(@SuppressWarnings("unused") Eleve e : elevestmp) {
				Eleve tmp = elevestmp.get(indiceListeEleves);
				indiceListeEleves = (indiceListeEleves + 1)%elevestmp.size();
				int x = tmp.getPosX();
				int y = tmp.getPosY();
				this.grille.getCells()[x][y].setContent(new Terrain(x, y));
				Cell direction = tmp.deplacement();
				
				
				if(!tmp.verifPunition()) 
				{
					//ElementdeJeu content = direction.getContent();
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
					else
					{
						traitementAction(tmp,4);
					}
					
				}
				else
				{
					exclure(tmp);
				}
				
				
				
			}
			if(this.inter) {
				this.map.repaint();
				Thread.sleep(100);
				
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


	
	

	



