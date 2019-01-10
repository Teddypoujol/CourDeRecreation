package Acteur;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;
import Systeme.*;

public class Eleve extends ElementdeJeu
{
	private int punition;
	private int portee;
	private String nom;
	private int visibilite;
	
	// Constructeurs de Eleve
	
	public Eleve(String nom, int visibilite,int port, int x, int y)
	{
		super(x,y);
		this.punition = 0;
		this.portee = port;
		this.nom=nom;
		this.visibilite=visibilite;
	}
	/*
	public Eleve()
	{
		super(id, nom, visibilite);	
		this.punition = 0;
		this.portee = 3;
	}
	*/
	
	// Méthodes d'un éléve
	
	public boolean verifPunition()
	{
		boolean virer;
		if(this.punition == 10)
		{
			virer = true;
		}
		else
		{
			virer = false;
		}
		return virer;
	}
	
	public int choisirAction()
	{
		int rand = new Random().nextInt(3);
		return rand;
	}
	
	public void majPunition()
	{
		this.punition = this.punition+1;
	}
	
	
	//deplacement en fonction de la visibilite
	public Cell deplacement() 
	{
		int x = this.getPosX();	
		int y = this.getPosY();
		int dir;
		
		Cell c = Controller.getInstance().getGrille().getCells[x][y];
		boolean ok = false;
		
		do {
			x = this.getPosX();
			y = this.getPosY();
			
			dir = new Random().nextInt(3);
			
			if(dir == 0 && x > 0) {
				x--;
			}
			else if(dir == 1 && )
			
			
		}
	}
	
	
	// Setter et getter des attributs de la classe
	
	public int getPunition() 
	{
		return punition;
	}
	
	public void setPunition(int punition) 
	{
		this.punition = punition;
	}
	
	public int getPortee() 
	{
		return portee;
	}
	
	public void setPortee(int portee) 
	{
		this.portee = portee;
	}
	
	public int getVisibilite() {
		return visibilite;
	}

	public String getNom() {
		return nom;
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
