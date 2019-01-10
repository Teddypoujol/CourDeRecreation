package Systeme;

import Acteur.Terrain;

public class Cell {
	private boolean empty;
	private ElementdeJeu content;

	/**
	 * Cree une Cell vide
	 */
	public Cell() {
		this.content = null;
		this.empty = true;
	}

	public boolean isEmpty() {
		return this.empty;
	}

	/**
	 * Renvoie le GameElement present dans cette Cell
	 * 
	 * @return le GameElement present dans cette Cell
	 */
	public ElementdeJeu getContent() {
		return this.content;
	}

	public void setContent(ElementdeJeu content) {
		this.content = content;
		if(content instanceof Terrain) {
			this.empty = true;
		} else {
			this.empty = false;
		}
}
}
