package Acteur;

import java.awt.Graphics;
import java.io.IOException;

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
	        case 0:  patience = patience - 3; //bagarre
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
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, int x, int y) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
