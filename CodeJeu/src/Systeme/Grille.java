package Systeme;

import Acteur.Terrain;

public class Grille 
{
	private int li;
	private int co;
	private Cell cells[][] = null;

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

	public int getLi() {
		return li;
	}

	public int getCo() {
		return co;
	}

	public Cell[][] getCells() {
		return cells;
	}


}