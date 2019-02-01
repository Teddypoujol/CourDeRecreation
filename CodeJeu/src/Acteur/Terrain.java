package Acteur;

import java.awt.Graphics;
import java.io.IOException;

import Systeme.ElementdeJeu;

/**
 * Le terrain est une case vide de la cours
 * c'est un element de jeu
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Elementdejeu
 * @version 2.0
 */

public class Terrain extends ElementdeJeu {
	/**
	 * Constructeur de Terrain
	 * @param x
	 * @param y
	 */

	public Terrain(int x, int y) {
		super(x, y);
	}

	

	@Override
	public void draw(Graphics g, int x, int y) throws IOException 
	{
		// TODO Auto-generated method stub
		
	}
}
