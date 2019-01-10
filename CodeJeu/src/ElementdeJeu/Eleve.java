package ElementdeJeu;

import java.util.Random;

public class Eleve extends Personne 
{
	private int punition;
	private int portee;
	
	// Constructeurs de Eleve
	
	public Eleve(int id, String nom, int visibilite,int puni,int port)
	{
		super(id, nom, visibilite);	
		this.punition = puni;
		this.portee = port;
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
