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
	private static int li = 6; // nombre de lignes de tiles
	
	/**

     *Nombre colonne du tile
			*@see CharsetCR#getInstance()

     */
	private static int co = 9; // nombre de colonnes de tiles
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
			tilesetImg = ImageIO.read(INSTANCE.getClass().getResource(Constant.getPathEnfants()));

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
	
	//fille bagarreuse
	public Tile getFilleBagarDebout() {
		return tileset[0][0];
	}

	public Tile getFilleBagarBagarre() {
		return tileset[0][1];
	}

	public Tile getFilleBagarDroite() {
		return tileset[0][2];
	}

	public Tile getFilleBagarHaut() {
		return tileset[1][0];
	}

	public Tile getFilleBagarBas() {
		return tileset[1][1];
	}

	public Tile getFilleBagarGauche() {
		return tileset[2][1];
	}
	
	//fille romantique
	public Tile getFilleRomDebout() {
		return tileset[0][3];
	}

	public Tile getFilleRomBisous() {
		return tileset[1][5];
	}

	public Tile getFilleRomDroite() {
		return tileset[0][5];
	}

	public Tile getFilleRomHaut() {
		return tileset[1][3];
	}

	public Tile getFilleRomBas() {
		return tileset[1][4];
	}

	public Tile getFilleRomGauche() {
		return tileset[2][4];
	}

	//fille Normale
	public Tile getFilleDebout() {
		return tileset[0][6];
	}

	public Tile getFilleBisous() {
		return tileset[1][8];
	}
	
	public Tile getFilleBagarre() {
		return tileset[0][7];
	}
	
	public Tile getFilleJouer() {
		return tileset[2][6];
	}

	public Tile getFilleDroite() {
		return tileset[0][8];
	}

	public Tile getFilleHaut() {
		return tileset[1][6];
	}

	public Tile getFilleBas() {
		return tileset[1][7];
	}

	public Tile getFilleGauche() {
		return tileset[2][7];
	}
	
	
	
	
	
	
	//Garcon bagarreuse
		public Tile getGarconBagarDebout() {
			return tileset[3][0];
		}

		public Tile getGarconBagarBagarre() {
			return tileset[3][1];
		}

		public Tile getGarconBagarDroite() {
			return tileset[3][2];
		}

		public Tile getGarconBagarHaut() {
			return tileset[4][0];
		}

		public Tile getGarconBagarBas() {
			return tileset[4][1];
		}

		public Tile getGarconBagarGauche() {
			return tileset[5][1];
		}
		
		//Garcon romantique
		public Tile getGarconRomDebout() {
			return tileset[3][3];
		}

		public Tile getGarconRomBisous() {
			return tileset[4][5];
		}

		public Tile getGarconRomDroite() {
			return tileset[3][5];
		}

		public Tile getGarconRomHaut() {
			return tileset[4][3];
		}

		public Tile getGarconRomBas() {
			return tileset[4][4];
		}

		public Tile getGarconRomGauche() {
			return tileset[5][4];
		}

		//Garcon Normale
		public Tile getGarconDebout() {
			return tileset[3][6];
		}

		public Tile getGarconBisous() {
			return tileset[4][8];
		}
		
		public Tile getGarconBagarre() {
			return tileset[3][7];
		}
		
		public Tile getGarconJouer() {
			return tileset[5][6];
		}

		public Tile getGarconDroite() {
			return tileset[3][8];
		}

		public Tile getGarconHaut() {
			return tileset[4][6];
		}

		public Tile getGarconBas() {
			return tileset[4][7];
		}

		public Tile getGarconGauche() {
			return tileset[5][7];
		}
		
		// nuage
		
		public Tile getNuage(){
			return tileset[5][8];
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