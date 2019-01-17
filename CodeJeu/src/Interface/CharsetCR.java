package Interface;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import Systeme.Constant;

public class CharsetCR implements Tileset {
	private static CharsetCR INSTANCE;
	private static Image tilesetImg = null;
	private static int li = 3; // nombre de lignes de tiles
	private static int co = 3; // nombre de colonnes de tiles
	private static int tileW = 60; // tile width
	private static int tileH = 60; // tile height
	private static Tile[][] tileset;

	private CharsetCR() {}

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



	@Override
	public Image getImage() {
		return tilesetImg;
	}

	@Override
	public int getTileW() {
		return tileW;
	}

	@Override
	public int getTileH() {
		return tileH;
	}
}