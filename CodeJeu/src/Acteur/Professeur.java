package Acteur;

import java.awt.Graphics;
import java.io.IOException;

import Systeme.ElementdeJeu;

public class Professeur extends ElementdeJeu {
	
	private int patience;
	private int anciennete;
	private String nom;
	private int visibilite;
	
	public Professeur(String nom, int visibilite, int patience, int anciennete, int x, int y) 
	{
		super(x, y);	
		this.patience = patience;
		this.anciennete = anciennete;
		this.nom=nom;
		this.visibilite=visibilite;
	}
	
	public int verifPatience() {
		int etatProf = 0;
		if(patience <= 10)etatProf = 1;
		if(patience == 0) etatProf = 2;
		
		return etatProf;
	}
	
	public boolean verifAnciennete() {
		boolean ancienneteProf = false;		
		if(anciennete >= 20) ancienneteProf = true;
		return ancienneteProf;
	}
	

	public void majPatience(int action) {
		switch (action) {
	        case 1:  patience = patience - 3; //bagarre
	                 break;
	        case 2:  patience = patience + 1; //bisous
	                 break;
	        case 3:  patience = patience - 10; //embete professeur
	                 break;
	        case 4:  patience = patience - 1; //pleure
	                 break;
	        default:
	                 break;
		}
	}
	
	public void addAnciennete() {
		anciennete += 1;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, int x, int y) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
