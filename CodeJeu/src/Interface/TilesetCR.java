package Interface;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import Systeme.Constant;

public class TilesetCR implements Tileset {
	private static TilesetCR INSTANCE;
	private static Image tilesetImg = null;
	private static int li = 3; // nombre de lignes de tiles
	private static int co = 3; // nombre de colonnes de tiles
	private int tileW = 65; // tile width
	private int tileH = 65; // tile height
	private static Tile[][] tileset;

	private TilesetCR() {}

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
	
	@Override
	public Image getImage() {
		return tilesetImg;
	}

	
}