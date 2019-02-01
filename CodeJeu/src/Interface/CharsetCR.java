package Interface;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import Acteur.Eleve;
import Acteur.Eleve.Direction;
import Systeme.Constant;
/**
 * CharsetCR classe permettant de gerer un charset et de pouvoir afficher les elements de jeu (ici les personnages)
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Tileset
 * @version 2.0
 */

public class CharsetCR implements Tileset {
	
	
	private static CharsetCR INSTANCE;
	
	
	/**

     *image contenant le tile
		*@see CharsetCR#getInstance()
		*@see CharsetCR#getImage()

     */
	private static Image tilesetImg = null;
	
	/**

     *Nombre ligne du tile
	*@see CharsetCR#getInstance()

     */
	private static int li = 3; // nombre de lignes de tiles
	
	/**

     *Nombre colonne du tile
			*@see CharsetCR#getInstance()

     */
	private static int co = 3; // nombre de colonnes de tiles
	/**

     *Largeur du tile
     *@see CharsetCR#getInstance()
     *@see CharsetCR#getTileW()
	
     */
	private static int tileW = 60; // tile width
	
	/**

	 *Hauteur du tile
	 *@see CharsetCR#getInstance()
	 *@see CharsetCR#getTileH()
	 *
     */
	private static int tileH = 60; // tile height
	
	/**

     * Declaration du tile
	*@see CharsetCR#getInstance()

     */
	private static Tile[][] tileset;

	
	private CharsetCR() {}

	/**
	 * Methode qui lit le fichier en le decoupant en grille de carre de 60 
	 * sur 60 et qui recupère chaque element de la grille pour l'ajouter a un tableau d'elements
	 * @return INSTANCE
	*/
	
	public static CharsetCR getInstance() throws IOException {
		if(INSTANCE == null) {
			INSTANCE = new CharsetCR();
			tilesetImg = ImageIO.read(INSTANCE.getClass().getResource(Constant.getPathFille1()));

			tileset = new Tile[li][co];
			for(int i = 0; i < li; i++) {
				for(int j = 0; j < co; j++) {
					tileset[i][j] = new Tile(getInstance(), j, i);
				}
			}
		}
		return INSTANCE;
	}

	/**
	 * Permet de recuperer l'image a l'endroit donne dans le tile
	 * @return tileset
	*/
	public Tile getFilleDebout() {
		return tileset[0][0];
	}

	public Tile getFilleBagarre() {
		return tileset[0][1];
	}

	public Tile getFilleDroite() {
		return tileset[0][2];
	}

	public Tile getFilleHaut() {
		return tileset[1][0];
	}

	public Tile getFilleBas() {
		return tileset[1][1];
	}

	

	public Tile getFilleGauche() {
		return tileset[2][1];
	}

	/**
	 * Permet de recuperer l'image 
	 * @return tilesetImg
	*/

	@Override
	public Image getImage() {
		return tilesetImg;
	}
	
	/**
	 * Permet de recuperer la largeur du tile
	 * @return tileW
	*/

	@Override
	public int getTileW() {
		return tileW;
	}

	/**
	 * Permet de recuperer la hauteur du tile
	 * @return tileh
	*/
	@Override
	public int getTileH() {
		return tileH;
	}
}