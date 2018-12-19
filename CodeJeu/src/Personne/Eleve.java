package Personne;

import java.util.Random;

public class Eleve extends Personne 
{
	private int punition;
	private int portee;
	
	// Constructeurs de Eleve
	
	public Eleve(int puni,int port)
	{
		this.punition = puni;
		this.portee = port;
	}
	
	public Eleve()
	{
		this.punition = 0;
		this.portee = 3;
	}
	
	// Méthodes d'un éléve
	
	public void deplacement() 
	{
		int rand = new Random().nextInt(3);
		
	}
	
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
	
	public void setPosition(int newx, int newy)
	{
		this.setPos_x(newx);
		this.setPos_y(newy);	
	}
	
	// Setteur et getteur des attributs de la classe
	
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
	
	
}
