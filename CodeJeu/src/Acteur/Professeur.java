package Acteur;

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

public class Professeur extends ElementdeJeu {
	
	private int patience;
	private int anciennete;
	private String nom;
	private int visibilite;
	
	public Professeur(String nom, int anciennete, int x, int y) 
	{
		super(x, y);	
		this.patience = 100;
		this.anciennete = anciennete;
		this.nom=nom;
		this.visibilite=5;
	}
	
	public boolean verifPatience() {
		boolean etatProf = false;
		if(patience <= 0)etatProf = true;
		return etatProf;
	}
	
	public boolean verifAnciennete() {
		boolean ancienneteProf = false;		
		if(anciennete >= 20) ancienneteProf = true;
		return ancienneteProf;
	}
	

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
		
		System.out.println(this.nom+ " : patience mise à jour, patience = " + patience);
	}
	
	public void addAnciennete() {
		anciennete += 1;
	}

	

	@Override
	public void draw(Graphics g, int x, int y) throws IOException 
	{
		Image profimg = ImageIO.read(getClass().getResource(Constant.getPathProf()));
		g.drawImage(profimg,y*60,x*60,(y+1)*60,(x+1)*60,0,0,60,60,Controller.getInstance().getMap());
		
	}
}
