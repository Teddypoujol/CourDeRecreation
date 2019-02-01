package Interface;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import Systeme.Constant;
/**
 * TilesetCR classe permettant de gerer un tileset et de pouvoir afficher les elements de jeu (ici le terrain)
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Tileset
 * @version 2.0
 */
public class TilesetCR implements Tileset {
	private static TilesetCR INSTANCE;
	
	/**

     *image contenant le tile
		*@see TilesetCR#getInstance()
		*@see TilesetCR#getImage()

     */
	private static Image tilesetImg = null;

	private static int li = 3; // nombre de lignes de tiles
	private static int co = 3; // nombre de colonnes de tiles
	private int tileW = 60; // tile width
	private int tileH = 60; // tile height
	private static Tile[][] tileset;


	private TilesetCR() {}

	/**
	 * Methode qui lit le fichier en le decoupant en grille de carre de 60 
	 * sur 60 et qui recupère chaque element de la grille pour l'ajouter a un tableau d'elements
	 * @return INSTANCE
	*/
	public static TilesetCR getInstance() throws IOException {
		if(INSTANCE == null) {
			INSTANCE = new TilesetCR();
			tilesetImg = ImageIO.read(INSTANCE.getClass().getResource(Constant.getPathCour()));
			tileset = new Tile[li][co];
			for(int i = 0; i < li; i++) {
				for(int j = 0; j < co; j++) {
					tileset[i][j] = new Tile(getInstance(), i, j);
				}
			}
		}
		return INSTANCE;
	}
	

	
	

	public Tile getCour() {
		return tileset[0][0];
	}
	
	

	@Override
	public int getTileW() {
		return this.tileW;
	}
	
	@Override
	public int getTileH() {
		return this.tileH;
	}
	/**
	 * Permet de recuperer l'image 
	 * @return tilesetImg
	*/

	@Override
	public Image getImage() {
		return tilesetImg;
	}

	
}