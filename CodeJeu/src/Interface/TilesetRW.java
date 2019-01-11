package Interface;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

import Systeme.Constant;

public class TilesetRW implements Tileset{
	private static TilesetRW INSTANCE;
	private static Image tilesetImg = null;
	private static int li = 2; // nombre de lignes de tiles
	private static int co = 2; // nombre de colonnes de tiles
	private int tileW = 200; // tile width
	private int tileH = 250; // tile height
	private static Tile[][] tileset;

	private TilesetRW() {}
	
	public static TilesetRW getInstance() throws IOException {
		if(INSTANCE == null) {
			INSTANCE = new TilesetRW();
			tilesetImg = ImageIO.read(INSTANCE.getClass().getResource(Constant.getPath1()));
			tileset = new Tile[li][co];
			for(int i = 0; i < li; i++) {
				for(int j = 0; j < co; j++) {
					tileset[i][j] = new Tile(getInstance(), i, j);
				}
			}
		}
		return INSTANCE;
	}
	

	public Tile getBlank() {
		return tileset[0][0];
}

	@Override
	public Image getImage() {
		return tilesetImg;
	}

	@Override
	public int getTileW() {
		return this.tileW;
	}

	@Override
	public int getTileH() {
		return this.tileH;
	}

}
