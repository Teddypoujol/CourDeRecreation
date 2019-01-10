package Acteur;

import java.awt.Graphics;
import java.io.IOException;

import Systeme.ElementdeJeu;


public class Terrain extends ElementdeJeu {
	public Terrain(int x, int y) {
		super(x, y);
	}

	@Override
	public void display() {
		System.out.print('.');
}

	@Override
	public void draw(Graphics g, int x, int y) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
