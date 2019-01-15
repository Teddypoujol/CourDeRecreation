package Lancement;

import java.io.IOException;

import Systeme.Controller;

public class Console extends Launcher {
	@Override
	protected void startGame() throws InterruptedException, IOException {
		Controller.getInstance().init(false);

		// Temps de configuration de la fenetre console
		System.out.println("Appuyez sur entrer");
		this.bufferReader.readLine();

		while(!Controller.getInstance().gameOver()) {
			Controller.getInstance().tourSuivant();
			Thread.sleep(1000);
		}
	}

	@Override
	public void launch() throws InterruptedException, IOException {
		String choice = null;
		boolean restart = true;

		this.startGame();
		do {
			System.out.println("<o> jouer a nouveau, <q> quitter.");
			choice = bufferReader.readLine();
			if((choice.toUpperCase()).equals("O")) {
				this.startGame();
			} else if((choice.toUpperCase()).equals("Q")) {
				restart = false;
			} else {
				System.out.println("Unknown.");
			}
		} while(restart);
		System.out.println("Aurevoir");
		System.exit(0);
	}
}