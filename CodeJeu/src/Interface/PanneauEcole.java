package Interface;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Systeme.Constant;
import Systeme.Controller;

public class PanneauEcole extends JPanel {

	public PanneauEcole() {
		
	}
	
	public void paintComponent(Graphics g)
	{
		Image ecoleimg;
		try {
			ecoleimg = ImageIO.read(getClass().getResource(Constant.getPathEcole()));
			g.drawImage(ecoleimg,0,0,Controller.getInstance().getMap());
			Image profimg = ImageIO.read(getClass().getResource(Constant.getPathProf()));
			g.drawImage(profimg,5*60,5*60,(5+1)*60,(5+1)*60,0,0,60,60,Controller.getInstance().getMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
