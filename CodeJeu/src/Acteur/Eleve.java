package Acteur;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;
import Systeme.*;

public class Eleve extends ElementdeJeu
{
	protected int punition;
	protected int portee;
	protected String nom;
	protected int visibilite;
	
	// Constructeurs de Eleve
	
	public Eleve(String nom,int port, int x, int y)
	{
		super(x,y);
		this.punition = 0;
		this.portee = port;
		this.nom=nom;
		this.visibilite=3;
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
		int i = new Random().nextInt(3);
		int dir = i;
		
		Cell c = Controller.getInstance().getGrille().getCells()[x][y];
		boolean ok = false;
		
		do {
			x = this.getPosX();
			y = this.getPosY();
			
			
			//HAUT
			if((dir == 0) && x > 0) {
				while(x>=x-portee || x>0) {
					x--;
				}
			}
			//BAS
			else if((dir == 1) && x < Constant.getMapHeight() - 1) {
				while(x<=x+portee || x< Constant.getMapHeight()) {
					x++;	
				}

			}
			//GAUCHE
			else if(dir==2 && y > 0) {
				while(y>=y-portee || y > 0) {
					y--;
				}
			}
			//DROITE
			else if((dir == 3) && y < Constant.getMapWidth() - 1 ) {
				while(y<=y+portee || y < Constant.getMapWidth()) {
					y++;
				}
			}	
			
			Cell test = Controller.getInstance().getGrille().getCells()[x][y];
			if(test.isEmpty()) {
				ok = true;
				c = test;
			}
			dir = (dir + 1)%4;
		}while (!ok || dir != i);
		return c;
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
