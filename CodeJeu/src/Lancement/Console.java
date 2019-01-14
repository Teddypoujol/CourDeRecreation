package Lancement;

import java.io.IOException;

import Systeme.Controller;

public class Console extends Launcher {
	@Override
	protected void startGame() throws InterruptedException, IOException {
		Controller.getInstance().init(false);

		// Temps de configuration de la fenetre console
		System.out.println("Press <Enter> to start.");
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
			System.out.println("<o> to play again, <q> to exit.");
			choice = bufferReader.readLine();
			if((choice.toUpperCase()).equals("O")) {
				this.startGame();
			} else if((choice.toUpperCase()).equals("Q")) {
				restart = false;
			} else {
				System.out.println("Unknown.");
			}
		} while(restart);
		System.out.println("Bye!");
		System.exit(0);
	}
}