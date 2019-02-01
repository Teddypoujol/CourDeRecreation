package Acteur;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import Acteur.Eleve.Direction;
import Systeme.Cell;
import Systeme.Constant;
import Systeme.Controller;

/**
 * Eleve turbulent extends de Eleve
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Eleve
 * @version 2.0
 */


public class EleveTurbulent extends Eleve {
	

	//private List<Eleve> listeEleve;
	
	/**

     *  Booleen retournant true si c'est un eleève bagarreur ou false si c'est un eleève romantique

     * 

     * @see EleveTurbulent#choisirAction()
     * @see EleveTurbulent#EleveTurbulent(String nom, int port, int x, int y, boolean )

     */

	private boolean estBagarreur;

	/**

     *  Constructeur de EleveTurbulent

     * @param nom  Le nom de l'elève turbulent
     * @param port La portee de l'elève
     * @param x Coordonnee
     * @param y Coordonnee
     * @param b boolean qui verifie si c'est un bagarreur

     * @see EleveTurbulent#choisirAction()

     */
	
	public EleveTurbulent(String nom, int port, int x, int y, boolean b) {
		super(nom, port, x, y);
		estBagarreur = b;
	}
	
	/**

     *  Methode qui permet de choisir l'action de l'elève, soit bagarre soit bisous


     * @see EleveTurbulent#estBagarreur
	 * @return action
     */
	
	
	public int choisirAction() {
		//bagarre = 0, bisous = 1, jouer = 2
		int action;
		if(!estBagarreur) {
			action = 1;
			System.out.println("declenche une bagarre");
		}else action = 0;
		
		return action;
	}
	
	
	/**
	 * Methode permettant de deplacer un elève turbulent au prochain tour de jeu 
	 * selon la direction choisie
	 * 
	 
	 * @see Eleve#nom
	 * @see Eleve#vers
	 * @see Eleve#portee
	 * @see Eleve#mouvement
	 * @see Eleve#getPosX()
	 * @see Eleve#getPosX()
	 * @see Eleve#Eleve(String nom,int port, int x, int y)
	 * @return Cell La nouvelle cellule
	 */
	
	public Cell deplacement() {

		int x = this.getPosX();	
		int y = this.getPosY();
		int xtmp, ytmp;
		Direction dir= null;
		Cell c;
		boolean ok = false;
		System.out.println(this.nom);
		System.out.println("emplacement : " + x + "  " + y);
		//recherche elève
		do {
			//parcour haut
			c = Controller.getInstance().getGrille().getCells()[x][y];
			xtmp = x;
			ytmp = y;
			while(!c.getContent().getClass().getName().equals("Acteur.Eleve") && (xtmp>x-visibilite && xtmp>0)) {
				xtmp--; 
				c = Controller.getInstance().getGrille().getCells()[xtmp][y];
			}	
			if(c.getContent() instanceof Eleve ) {					
				dir = Direction.UP;
				System.out.println("elève trouve" + dir);
				System.out.println(xtmp + "  " + ytmp);
				ok = true;
			}
			
			
			//parcour bas
			c = Controller.getInstance().getGrille().getCells()[x][y];
			xtmp = x;
			ytmp = y;
			while(!c.getContent().getClass().getName().equals("Acteur.Eleve") && (xtmp<x+visibilite && xtmp < Constant.getMapHeight() - 1)) {
				xtmp++; 
				c = Controller.getInstance().getGrille().getCells()[xtmp][y];
			}
			if(c.getContent().getClass().getName().equals("Acteur.Eleve")) {
				dir = Direction.DOWN;
				System.out.println("elève trouve" + dir);
				System.out.println(xtmp + "  " + ytmp);
				ok = true;
			}
			
			//parcour gauche
			c = Controller.getInstance().getGrille().getCells()[x][y];
			xtmp = x;
			ytmp = y;
			while(!c.getContent().getClass().getName().equals("Acteur.Eleve") && (ytmp>y-visibilite && ytmp>0)) {
				ytmp--; 
				c = Controller.getInstance().getGrille().getCells()[x][ytmp];
			}
			if(c.getContent().getClass().getName().equals("Acteur.Eleve")) {
				dir = Direction.LEFT;
				System.out.println("elève trouve" + dir);
				System.out.println(xtmp + "  " + ytmp);
				ok = true;
			}
			
			//parcour droite
			c = Controller.getInstance().getGrille().getCells()[x][y];
			xtmp = x;
			ytmp = y;
			while(!c.getContent().getClass().getName().equals("Acteur.Eleve") && (ytmp<y+visibilite && ytmp < Constant.getMapWidth()-1)) {
				ytmp++; 
				c = Controller.getInstance().getGrille().getCells()[x][ytmp];
			}
			if(c.getContent().getClass().getName().equals("Acteur.Eleve")) {
				dir = Direction.RIGHT;
				System.out.println("elève trouve" + dir);
				ok = true;
			}
			
			ok=true;
		}while(ok!=true);
		
		//deplacement en direction de l'elève trouve
		if(dir!=null) {
		
			x = this.getPosX();
			y = this.getPosY();
			xtmp = x;
			ytmp = y;
			this.vers = dir;
			
			//HAUT
			if(dir.equals(Direction.UP) && x-portee >= 0) {
				while(xtmp>x-portee && xtmp>0) {
					xtmp--;
				}
			}
			//BAS
			else if(dir.equals(Direction.DOWN) && x+portee < Constant.getMapHeight()) {
				xtmp = x;
				ytmp = y;
				while(xtmp<x+portee & xtmp< Constant.getMapHeight()) {
					xtmp++;	
				}
				
			}
			//GAUCHE
			else if(dir.equals(Direction.LEFT) && y-portee >= 0) {
				xtmp = x;
				ytmp = y;
				while(ytmp>y-portee & ytmp > 0) {
					ytmp--;
				}
			}
			//DROITE
			else if((dir.equals(Direction.RIGHT)) && y+portee < Constant.getMapWidth() ) {
				xtmp = x;
				ytmp = y;
				while(ytmp<y+portee && y < Constant.getMapWidth()) {
					ytmp++;
				}
			}	
			
			Cell test = Controller.getInstance().getGrille().getCells()[xtmp][ytmp];
			if(test.isEmpty()) {
				c = test;
				this.setPosX(xtmp);
				this.setPosY(ytmp);
			}else {
				c = Controller.getInstance().getGrille().getCells()[x][y];
			}
		}else {
			c = super.deplacement();
		}
		return c;
	}
	

	/**
	 * Methode qui permet de dessiner de tile correcpondant a lelève
	 * @param g le graphics de java swing qui permet d'afficher
	 * @param x L'abscisse du dessin
	 * @param y L'ordonnee du dessin
	 * @see Eleve#vers
	
	 */
	
	@Override
	public void draw(Graphics g, int x, int y) throws IOException 
	{
		Image garsimg = ImageIO.read(getClass().getResource(Constant.getPathGarcon()));
		g.drawImage(garsimg,y*60,x*60,(y+1)*60,(x+1)*60,0,0,60,60,Controller.getInstance().getMap());
		
	}
}
