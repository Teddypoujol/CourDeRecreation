package Acteur;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;
import Systeme.*;

public class Eleve extends ElementdeJeu
{
	public static enum Direction {
		UP, 
		DOWN, 
		LEFT, 
		RIGHT
	}
	private static int nb = 0;
	protected final Direction[] directions = Direction.values();

	protected int punition;
	protected int portee;
	protected String nom;
	protected int visibilite;
	protected Direction vers;
	
	// Constructeurs de Eleve
	
	public Eleve(String nom,int port, int x, int y)
	{
		super(x,y);
		this.punition = 0;
		this.portee = port;
		this.nom=nom;
		this.visibilite=3;
		this.vers = Direction.DOWN;
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
		//bagarre = 0, bisous = 1, jouer = 2
		int action = new Random().nextInt(2);
		switch (action){
			case 0 :System.out.println("déclenche bagarre");
					break;
			case 1 :System.out.println("fais bisous");
					break;
			case 2 :System.out.println("joue");
					break;
		}
		return action;
	}
	
	public void majPunition()
	{		
		this.punition = this.punition+1;
		System.out.println("se fait punir, punition = " + this.punition);
	}
	
	
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
			if(test.isEmpty()) {
				c = test;
				ok = true;				
			}
			dir = (dir + 1)%directions.length;
		}while (!ok || dir != i);
		if(ok) {
			System.out.println(this.vers.toString());
			System.out.println("nouvel emplacement : " + xtmp + "  " + ytmp);
			this.setPosX(xtmp);
			this.setPosY(ytmp);
		}
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
