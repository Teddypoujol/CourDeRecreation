package Lancement;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import Systeme.Controller;
import Interface.*;

public class Graphique extends Launcher {
	private boolean closed = false;
	private volatile int sleep = 0; // La variable indique le temps d'endormissement en millisecondes. 0 signifie qu'il n'est pas nécéssaire de s'endormir.
	// On utilise également "volatile" car la variable dois être lue par deux threads différents.
	// De même, on utilise un int pour que les affectations soient atomiques (ce ne serait pas forcément le cas avec un long de 64 bits)

	

	
	
	private static Graphique INSTANCE;
	public static Graphique getInstance() 
	{
		if(INSTANCE == null) 
		{
			INSTANCE = new Graphique();
			
		}
		return INSTANCE;
	}
	
	@Override
	protected void startGame() throws InterruptedException, IOException {
		while(!Controller.getInstance().isGameStarted()) {
			Thread.sleep(1000);
		}

		while(!Controller.getInstance().gameOver()) {
			
				Controller.getInstance().tourSuivant();
				Thread.sleep(100);
		}
		
	}

	@Override
	public void launch() throws InterruptedException, IOException {
		
		FenetreParametres winParam = new FenetreParametres();

		winParam.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closed = true;
			}
		});
		
		do {
			// Attente de la saisie des parametres initiaux
			while(!Controller.getInstance().gameIsInit()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			try {
				startGame();
			} catch (InterruptedException | IOException e1) {
				e1.printStackTrace();
			}
		} while(!closed);
	}
}