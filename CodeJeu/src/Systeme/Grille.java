package Systeme;

import Acteur.Terrain;

public class Grille implements Displayable {
	private int li;
	private int co;
	private Cell cells[][] = null;

	public Grille(int width, int height) {
		this.li = width;
		this.co = height;
		this.cells = new Cell[width][height];

		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
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

	@Override
	public void display() {
		for(int i = 0; i < this.li; i++) {
			for(int j = 0; j < this.co; j++) {
				System.out.print(" ");
				this.cells[i][j].getContent().display();
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}