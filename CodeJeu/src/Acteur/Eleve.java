package Acteur;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Interface.CharsetCR;
import Systeme.*;


/**
 * Eleve est la classe representant un elève dans la cour de recreation
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @version 2.0
 */


public class Eleve extends ElementdeJeu
{
	
	 /**

     * Liste des directions possibles de l'elève

     * 

     * @see Direction#deplacement()
     * @see Direction#draw(Graphics g, int x, int y)


     */
	public static enum Direction {
		UP, 
		DOWN, 
		LEFT, 
		RIGHT
	}
	
	
	public int getNbvie()
	{
		return nbvie;
	}
	
	/**
	* Action actuelle de l'eleve
	*/
	protected int actionEnCours;
	/**

     * nb voulue entre par l'utilisateur

     * 

     * @see nb#deplacement()


     */
	
	private static int nb = 0;
	protected final Direction[] directions = Direction.values();

	/**

     *  punition Correspondant au nombre de punition de l'elève

     * 

     * @see Eleve#verifPunition()

	  *@see Eleve#majPunition()
	  * @see Eleve#getPunition()
	  * *@see Eleve#setPunition()
     */
	protected int punition;
	
	protected int nbvie = 3;
	
	protected boolean sex = true;
	/**

     * portee Correspondant a la portee de l'elève

     * 

     * @see Eleve#setPortee()

	  *@see Eleve#getPortee()
     */
	protected int portee;
	
	/**

     * nom Correspondant au nom de l'elève

     * 

     * @see Eleve#getNom()

     */
	
	protected String nom;
	
	
	/**

     * visibilite  Donne la visibilite de l'elève

     * 

     * @see Eleve#getVisibilite()

     */
	protected int visibilite;
	protected Direction vers;
	
	
	protected boolean mouvement = false;
	// Constructeurs de Eleve
	
	
	/**
	 * Constructeur de la classe Eleve
	 * 
	 * @param nom  Le nom d'un elève
	 * @param port La portee de lelève 
	 * @param x Place sur l'axe des abscisses de la grille
	 * @param y Place sur l'axe des ordonnees de la grille
	 */

	public Eleve(boolean sex,String nom,int port, int x, int y)
	{
		super(x,y);
		this.sex = sex;
		this.punition = 0;
		this.portee = port;
		this.nom=nom;
		this.visibilite=3;
		this.vers = Direction.DOWN;
	}

	
	// Methodes d'un eleve
	

	/**
	 * Methode qui verifie si l'elève doit être vire ou non selon son nombre de punition
	 * 
	 * @see Eleve#punition
	 * @return virer
	 */
	
	public boolean verifPunition()
	{
		boolean virer;
		if(this.punition >= 3)
		{
			virer = true;
		}
		else
		{
			virer = false;
		}
		return virer;
	}
	
	/**
	 * VerifPunition Methode qui verifie si l'elève doit être vire ou non selon son nombre de punition
	 * 
	 * @return action Un entier action qui donne l'action que va effectuer l'elève
	 */
	public int choisirAction()
	{
		//bagarre = 0, bisous = 1, jouer = 2
		int action = new Random().nextInt(3);
		switch (action){
			case 0 :System.out.println("declenche bagarre");
					break;
			case 1 :System.out.println("fais bisous");
					break;
			case 2 :System.out.println("joue");
					break;
		}
		this.actionEnCours = action;
		return action;
	}
	
	
	
	/**
	 * Methode qui met a jour le nombre de punition d'un elève 
	 * @see Eleve#punition
	 */
	
	public void majPunition()
	{		
		this.punition = this.punition+1;
		System.out.println("se fait punir, punition = " + this.punition);
	}
	
	
	/**
	 * Methode permettant de deplacer un elève au prochain tour de jeu 
	 * selon la direction choisie
	 * 
	 * @see Eleve#nom
	 * @see Eleve#vers
	 * @see Eleve#portee
	 * @see Eleve#mouvement
	 * @return Cell La nouvelle cellule
	 */

	
	//deplacement en fonction de la visibilite
	public Cell deplacement() 
	{
		int x = this.getPosX();	
		int y = this.getPosY();
		int i = new Random().nextInt(directions.length);
		int dir = i;
		int xtmp, ytmp;
		
		Cell c = Controller.getInstance().getGrille().getCells()[x][y];
		boolean ok = false;
		//Direction direction = directions[dir];
		System.out.println(this.nom);
		System.out.println("emplacement : " + x + "  " + y);
		do {
			x = this.getPosX();
			y = this.getPosY();	
			xtmp = x;
			ytmp = y;
			Direction direction = directions[dir];
			this.vers = direction;

			//HAUT
			if((direction.equals(Direction.UP)) && x-portee >= 0) {
				while(xtmp>x-portee && xtmp>0) {
					xtmp--;
				}
			}
			//BAS
			else if((direction.equals(Direction.DOWN)) && x+portee < Constant.getMapHeight()) {
				xtmp = x;
				ytmp = y;
				while(xtmp<x+portee && xtmp< Constant.getMapHeight()) {
					xtmp++;	
				}
			}
			//GAUCHE
			else if(direction.equals(Direction.LEFT) && y-portee >= 0) {
				xtmp = x;
				ytmp = y;
				while(ytmp>y-portee && ytmp > 0) {
					ytmp--;
				}
			}
			//DROITE
			else if((direction.equals(Direction.RIGHT)) && y+portee < Constant.getMapWidth() ) {
				xtmp = x;
				ytmp = y;
				while(ytmp<y+portee && ytmp < Constant.getMapWidth()) {
					ytmp++;
				}
			}	
			
			Cell test = Controller.getInstance().getGrille().getCells()[xtmp][ytmp];
			System.out.println(test.isEmpty());
			if(test.isEmpty()) {
				
				c = test;
				ok = true;				
			}
			dir = (dir + 1)%directions.length;
		}while (!ok && dir != i);
		if(ok) {
			System.out.println(this.vers.toString());
			System.out.println("nouvel emplacement : " + xtmp + "  " + ytmp);
			this.setPosX(xtmp);
			this.setPosY(ytmp);
			mouvement=true;
			//this.vers = direction;
		}
		return c;
	}
	
	
	// Setter et getter des attributs de la classe
	/**
	 * Methode qui recupère punition
	 * @see Eleve#punition
	 * 
	 * @return {@link Eleve#punition}punition
	 */

	public int getPunition() 
	{
		return punition;
	}
	
	/**
	 * Methode qui modifie la variable punition
	 * @param puni  la punition voule
	 * @see Eleve#punition
	 */
	
	public void setPunition(int puni) 
	{
		this.punition = puni;
	}
	
	/**
	 * Methode qui recupère la portee de l'elève
	 * @return Eleve#portee
	
	 */

	public int getPortee() 
	{
		return portee;
	}
	
	/**
	 * Methode qui modifie la portee de l'elève
	 * @param port la portee voule
	 * @see Eleve#portee
	
	 */
	
	public void setPortee(int port) 
	{
		this.portee = port;
	}
	
	/**
	 * Methode qui recupère la visibilite
	 * @return visibilite
	
	 */
	
	public int getVisibilite() {
		return visibilite;
	}
	
	public boolean getSex()
	{
		return sex;
	}

	/**
	 * Methode qui recupère le nom d'un elève
	 * @return nom
	
	 */
	public String getNom() {
		return nom;
	}
	
	public void initAction() {
		actionEnCours = -1;
	}

	/**
	 * Methode qui permet de savoir si l'elève est en cours de deplacement
	 * @see Eleve#mouvement
	 * @return mouvement
	 */
	
	public boolean sedeplace() {
		return mouvement;
	}
	
	/**
	 * Methode qui permet de dessiner de tile correcpondant a lelève
	 * @param g le graphics de java swing qui permet d'afficher
	 * @param x L'abscisse du dessin
	 * @param y L'ordonnee du dessin
	 * @see Eleve#vers
	
	 */
	
	@Override
	public void draw(Graphics g, int x, int y) throws IOException {
		
		
		
		if(sex==true) {
			if(actionEnCours!=-1) {
				switch(actionEnCours) {
					case 0 : CharsetCR.getInstance().getGarconBagarre().drawTile(g, x, y,this); break;
					case 1 : CharsetCR.getInstance().getGarconBisous().drawTile(g, x, y,this); break;
					case 2 : CharsetCR.getInstance().getGarconJouer().drawTile(g, x, y,this); break;
				}
			}
			else {
				if(!sedeplace()) {
					CharsetCR.getInstance().getGarconDebout().drawTile(g, x, y,this);
				}
				else {
						if(this.vers == Direction.DOWN) {
							CharsetCR.getInstance().getGarconBas().drawTile(g, x, y,this);
						} else if(this.vers == Direction.UP) {
							CharsetCR.getInstance().getGarconHaut().drawTile(g, x, y,this);
						} else if(this.vers == Direction.LEFT) {
							CharsetCR.getInstance().getGarconGauche().drawTile(g, x, y,this);
						} else {
							CharsetCR.getInstance().getGarconDroite().drawTile(g, x, y,this);
						}
					}	
			}
		}
		else {
			if(actionEnCours!=-1) {
				switch(actionEnCours) {
				case 0 : CharsetCR.getInstance().getFilleBagarre().drawTile(g, x, y,this); break;
				case 1 : CharsetCR.getInstance().getFilleBisous().drawTile(g, x, y,this); break;
				case 2 : CharsetCR.getInstance().getFilleJouer().drawTile(g, x, y,this); break;
				}
			}
			else {
				if(!sedeplace()) {
					CharsetCR.getInstance().getFilleDebout().drawTile(g, x, y,this);
				}
				else {
						if(this.vers == Direction.DOWN) {
							CharsetCR.getInstance().getFilleBas().drawTile(g, x, y,this);
						} else if(this.vers == Direction.UP) {
							CharsetCR.getInstance().getFilleHaut().drawTile(g, x, y,this);
						} else if(this.vers == Direction.LEFT) {
							CharsetCR.getInstance().getFilleGauche().drawTile(g, x, y,this);
						} else {
							CharsetCR.getInstance().getFilleDroite().drawTile(g, x, y,this);
						}
					}	
			}	
		}	
		
		int dy=0;
		
		for(int i =0;i<getNbvie() - this.getPunition();i++)
		{
			BufferedImage vieEleve = ImageIO.read(getClass().getResource(Constant.getPathCoeur()));
			g.drawImage(vieEleve,y*60+10+dy,x*60+50,Controller.getInstance().getMap());
			dy=dy+12;
			
		}
		//String punition = Integer.toString(getPunition());
		//g.drawString(punition,getPosX(),getPosY());
	}
}

