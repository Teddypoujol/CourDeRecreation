package Lancement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Launcher {
	protected BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

	protected abstract void startGame() throws InterruptedException, IOException;
	public abstract void launch() throws InterruptedException, IOException;

	public BufferedReader getBufferReader() {
		return bufferReader;
	}
}