package Systeme;

import Acteur.Terrain;
/**
 * Classe permettant de definir la grille de jeu
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Drawable
 * @version 2.0
 */
public class Grille 
{
	/**
	 * Le nombre de lignes de la grille
	 */
	private int li;
	/**
	 * Le nombre de colonnes de la grille
	 */
	private int co;
	
	/**
	 * Initialisation d'une matrice de cellule
	 */
	private Cell cells[][] = null;

	/**
	 * Constructeur de la grille
	 * @param height la hauteur de la grille de jeu
	 * @param width la largeur de la grille de jeu
	 */
	public Grille(int height, int width) {
		this.li = height;
		this.co = width;
		this.cells = new Cell[height][width];

		for(int i = 0; i < height; i++) {
			for(int j = 0; j <width; j++) {
				this.cells[i][j] = new Cell();
				this.cells[i][j].setContent(new Terrain(i, j));
			}
		}
	}

	/**
	 * Recupère les lignes
	 * @return li le nombre de lignes
	 */
	public int getLi() {
		return li;
	}

	/**
	 * Recupère les colonnes
	 * @return co le nombre de colonnes
	 */
	public int getCo() {
		return co;
	}

	/**
	 * Recupère la matrice de cellules
	 * @return cells les cellules
	 */
	public Cell[][] getCells() {
		return cells;
	}


}