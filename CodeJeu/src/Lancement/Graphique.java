package Lancement;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import Systeme.Controller;
import Interface.*;

public class Graphique extends Launcher {
	private boolean closed = false;

	@Override
	protected void startGame() throws InterruptedException, IOException {
		while(!Controller.getInstance().isGameStarted()) {
			Thread.sleep(1000);
		}

		while(!Controller.getInstance().gameOver()) {
			Controller.getInstance().tourSuivant();
			Thread.sleep(1000);
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