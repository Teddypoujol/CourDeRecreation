package Acteur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Interface.CharsetCR;
import Interface.TilesetCR;
import Systeme.Constant;
import Systeme.Controller;
import Systeme.ElementdeJeu;

/**
 * Professeur, classe permettant de representer un professeur dans la cour de recreation
 * c'est un element de jeu
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Elementdejeu
 * @version 2.0
 */

public class Professeur extends ElementdeJeu {
	
	private int patience;
	private int anciennete;
	private String nom;
	private int visibilite;
	
	
	public int getPatience()
	{
		return patience;
	}
	
	/**
	 * Constructeur de la classe professeur, permet de creer un professeur
	 * @param nom  Le nom du professeur
	 * @param anciennete l'anciennete du professeur
	 * @param x Place sur l'axe des abscisses de la grille
	 * @param y Place sur l'axe des ordonnees de la grille
	 */
	
	
	public Professeur(String nom, int anciennete, int x, int y) 
	{
		super(x, y);	
		this.patience = 100;
		this.anciennete = anciennete;
		this.nom=nom;
		this.visibilite=5;
	}
	
	

	/**
	 * VerifPatience Methode qui verifie l'etat du professeur au niveau de sa patience, si il n'a plus aucune patience 
	 * le professeur part en burnout (patience = 0)
	 * 
	 * @see Professeur#patience
	 * @return etatProf
	 */
	
	
	public boolean verifPatience() {
		boolean etatProf = false;
		if(patience <= 0)etatProf = true;
		return etatProf;
	}
	
	
	/**
	 * VerifAnciennete Methode qui verifie si le professeur peut encore enseigner malgres son age avance
	 * 
	 * @see Professeur#anciennete
	 * @return ancienneteProf
	 */
	
	public boolean verifAnciennete() {
		boolean ancienneteProf = false;		
		if(anciennete >= 20) ancienneteProf = true;
		return ancienneteProf;
	}
	
	/**
	 * majPatience met a jour la patience du professeur selon l'action d'un elève autour de lui.
	 * @param action 
	 * @see Professeur#patience
	 */

	public void majPatience(int action) {
		switch (action) {
	        case 0:  patience = patience - 10; //bagarre
	                 break;
	        case 1:  if(patience<100)patience = patience + 1; //bisous
	                 break;
	        case 3:  patience = patience - 10; //embete professeur
	                 break;
	        case 4:  patience = patience - 1; //pleure
	   
	                 break;
	        default:
	                 break;
		}
		
		System.out.println(this.nom+ " : patience mise a jour, patience = " + patience);
	}
	
	/**
	 * addAnciennete a chaque tour de jeu de professeur gagne 1 an d'anciennete
	 
	 * @see Professeur#anciennete
	 */
	
	public void addAnciennete() {
		anciennete += 1;
	}

	/**
	 * Methode qui permet de dessiner de tile correcpondant au professeur
	 * @param g le graphics de java swing qui permet d'afficher
	 * @param x L'abscisse du dessin
	 * @param y L'ordonnee du dessin
	 */

	@Override
	public void draw(Graphics g, int x, int y) throws IOException 
	{
		Image profimg = ImageIO.read(getClass().getResource(Constant.getPathProf()));
		g.drawImage(profimg,y*60,x*60,(y+1)*60,(x+1)*60,0,0,60,60,Controller.getInstance().getMap());
		g.setColor(Color.GREEN);
		String punition = Integer.toString(getPatience());
		g.drawString(punition,y * 60 +25,x * 60);
		
	}
}
