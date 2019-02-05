package Systeme;

import Interface.Tileset;

/**
 * Classe permettant de representer un element de jeu par sa position
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Drawable
 * @version 2.0
 */
public abstract class ElementdeJeu implements Drawable{
	/**
	 * Position en abscisse de l'element de jeu
	 */
	
	private int pos_x;
	
	/**
	 * Position en ordonnee de l'element de jeu
	 */
	private int pos_y;
	
	/**
	 * Constructeur de ElementdeJeu
	 * @param PosX Position en abscisse de l'element de jeu
	 * @param posy Position en ordonnee de l'element de jeu
	 */
	
	public ElementdeJeu(int posX, int posY) {
		super();
		this.pos_x = posX;
		this.pos_y = posY;
	}
	
	/**
	 * Recupère la position en x
	 * @return pos_x la position
	 */

	public int getPosX() {
		return this.pos_x;
	}
	
	/**
	 * Modifie la position en x
	 * @param posX La nouvelle coordonnee
	 */

	public void setPosX(int posX) {
		this.pos_x = posX;
	}
	
	/**
	 * Recupère la position en y
	 * @return pos_y la position
	 */

	public int getPosY() {
		return this.pos_y;
	}

	/**
	 * Modifie la position en y
	 * @param posY La nouvelle coordonnee
	 */
	public void setPosY(int posY) {
		this.pos_y = posY;
	}

}
