package Interface;
import java.awt.Image;
/**
 * Interface des tiles permettant de recuperer les parametres d'un tile
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Elementdejeu
 * @version 2.0
 */
public interface Tileset {
	/**
	 * Permet de recuperer l'image du tile
	 */
	Image getImage();
	/**
	 * Permet de recuperer la largeur du tile
	 */
	int getTileW();
	/**
	 * Permet de recuperer la hauteur du tile
	 */
	int getTileH();

}
