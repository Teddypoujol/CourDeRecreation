package Systeme;

import Acteur.Terrain;
import Interface.Tileset;
/**
 * Classe permettant de representer une cellule du jeu soit celle ci est vide soit
 * elle contient un element de jeu
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Tileset
 * @version 2.0
 */

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
	 * Renvoie l'element de jeu present dans cette Cell
	 * 
	 * @return l'element de jeu present dans cette Cell
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
