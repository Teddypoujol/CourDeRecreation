package Interface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Acteur.Eleve;
import Acteur.Eleve.Direction;
import Acteur.Professeur;
import Systeme.Controller;
/**
 * Tile est une partie d'une image (tileset ou charset)
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Elementdejeu
 * @version 2.0
 */
public class Tile {
	
	/**
	 * Tileset dont est issu le Tile
	 */
	private Tileset ts;
	/**
	 * Numero de position de ligne du tile dans le tileset
	 */
	private int numPosX;
	/**
	 * Numero de position de colonne du tile dans le tileset
	 */
	private int numPosY;
	/**
	 * Longueur du Tile
	 */
	private int width;
	/**
	 * Hauteur du Tile
	 */
	private int height;

	public Tile(Tileset t, int x, int y) {
		super();
		this.ts = t;
		this.numPosX = x;
		this.numPosY = y;
		this.width = ts.getTileW();
		this.height = ts.getTileH();
	}

	
	public void drawTile(Graphics g, int x, int y, Object o) {
		int tx = this.numPosX * this.height;
		int ty = this.numPosY * this.width;
		g.drawImage(this.ts.getImage(), 
				y * this.ts.getTileW(),x * this.ts.getTileH() ,(y + 1) * this.ts.getTileW() , (x + 1) * this.ts.getTileH(), 
		tx , ty, tx + this.ts.getTileH(), ty + this.ts.getTileW(), 
		Controller.getInstance().getMap());
		
		BasicStroke b = new BasicStroke(3);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(b);
		g2.setColor(Color.RED);
		if(o instanceof Eleve) {
			Eleve e = (Eleve)o;
			
			String punition = Integer.toString(e.getPunition());
			g2.drawString(punition,y * this.ts.getTileW()+50,x * this.ts.getTileH()+50);
			g2.setColor(Color.MAGENTA);
			if(e.getSex())
			{
				g2.setColor(Color.CYAN);
			}
			
			g2.drawString(e.getNom(),y * this.ts.getTileW(),x * this.ts.getTileH());
		}
	
	}
/*	public void drawTile(Graphics g, int x, int y, Direction direction) {
		int tx = this.numPosX * this.height;
		int ty = this.numPosY * this.width;
		int offsetX;
		int offsetY;
		
		if(direction.equals(Direction.UP)) {
			offsetX = -this.ts.getTileH()/2;
			offsetY = 0;
		} else if(direction.equals(Direction.DOWN)) {
			offsetX = this.ts.getTileH()/2;
			offsetY = 0;
		} else if(direction.equals(Direction.LEFT)) {
			offsetX = 0;
			offsetY = -this.ts.getTileW()/2;
		} else {
			
			offsetX = 0;
			offsetY = this.ts.getTileW()/2;
		}

		g.drawImage(this.ts.getImage(), 
		x * this.ts.getTileH() + offsetX, 
		y * this.ts.getTileW() + offsetY, 
		(x + 1) * this.ts.getTileH() + offsetX, 
		(y + 1) * this.ts.getTileW() + offsetY, 
		tx , ty, tx + this.ts.getTileH(), ty + this.ts.getTileW(), 
		Controller.getInstance().getMap());
}*/

}
