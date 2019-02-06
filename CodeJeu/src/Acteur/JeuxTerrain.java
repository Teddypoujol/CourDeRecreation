package Acteur;

import java.awt.Graphics;
import java.io.IOException;

import Interface.CharsetCR;
import Interface.TilesetCR;
import Systeme.ElementdeJeu;

public class JeuxTerrain extends ElementdeJeu{
	private int type;
	
	public JeuxTerrain(int type,int posX, int posY) {
		super(posX, posY);
		this.setType(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g, int x, int y) throws IOException {
		// TODO Auto-generated method stub
		/*
		if(type == 0)
		{
			
			TilesetCR.getInstance().getArbreHaut().drawTile(g, x,y ,this);
			TilesetCR.getInstance().getArbreBas().drawTile(g, x+1, y,this);
			
			
		}
		else if(type==1) {
			TilesetCR.getInstance().getBalancoire1().drawTile(g, x, y,this);
		}else if(type==2) {
			TilesetCR.getInstance().getBalancoire2().drawTile(g, x, y,this);
		}else if(type==3) {
			TilesetCR.getInstance().getToboggan().drawTile(g, x, y,this);
		}else if(type==4) {
			TilesetCR.getInstance().getBasculeG().drawTile(g, x, y,this);
			TilesetCR.getInstance().getBasculeD().drawTile(g, x, y+1,this);
		}
		*/
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
