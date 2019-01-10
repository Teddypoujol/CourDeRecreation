package Systeme;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

import Acteur.Eleve;
import Acteur.Personne;
import Acteur.Professeur;

public class Controller 
{
	private static Controller INSTANCE;
	private List<Eleve> eleves;
	private List<Professeur> professeurs;
	private List<Eleve> vire;
	private List<Professeur> burnout;
	private List<ElementdeJeu> buffer;
	private Grid grid;
	private Window window;
	private Map map;
	private int nb_field_rabbits;

	
	private int nb_Professeurs;
	private int nb_Eleves;

	private boolean ihm = false;
	private boolean gameInited;
	private boolean gameStarted;

	private boolean gameover;
	private Random random = new Random();
	
	private Controller() 
	{
	}
	/*
	 * Singleton
	 */
	public static Controller getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Controller();
			INSTANCE.gameInited = false;
		}
		return INSTANCE;
	}

	public List<Eleve> getEleves() {
		return this.eleves;
	}

	public List<BabyRabbit> getBabyRabbits() {
		return this.babyRabbits;
	}

	public List<RegularCarrot> getCarrots() {
		return this.carrots;
	}

	public List<PoisonCarrot> getPoisons() {
		return this.poisons;
	}

	public Grid getGrid() {
		return this.grid;
	}

	public Window getWindow() {
		return window;
	}

	public Map getMap() {
		return map;
	}

	public boolean isIhm() {
		return ihm;
	}

	public void setIhm(boolean ihm) {
		this.ihm = ihm;
	}

	
}
