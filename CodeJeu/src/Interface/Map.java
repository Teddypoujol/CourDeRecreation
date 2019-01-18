package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Acteur.*;
import Systeme.*;

public class Map extends JPanel {
	private static final long serialVersionUID = 1L;
	private Controller ctrl = Controller.getInstance();

	public Map() {
		super();
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keys = e.getKeyCode();
				if(keys == KeyEvent.VK_ENTER || keys == KeyEvent.VK_F5) {
					ctrl.setGameStarted(true);
					repaint();
					removeKeyListener(this);
				}
			}
		});

		
		    
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		try {
			for(int i = 0; i < this.ctrl.getGrille().getLi(); i++) {
				for(int j = 0; j < this.ctrl.getGrille().getCo(); j++) {
					TilesetCR.getInstance().getCour().drawTile(g2d, i, j);
					//System.out.println(i + "  " + j +"  "+ this.ctrl.getGrille().getCells()[i][j].isEmpty());
				}
			}

			for(Professeur p : this.ctrl.getProfesseurs()) 
			{
				p.draw(g2d, p.getPosX(), p.getPosY());
			}
			
			for(Eleve e : this.ctrl.getEleves()) 
			{
				e.draw(g2d, e.getPosX(), e.getPosY());
			}
			
			for(EleveTurbulent et : this.ctrl.getElevesT()) 
			{
				et.draw(g2d, et.getPosX(), et.getPosY());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(!ctrl.isGameStarted()) {
			g2d.setColor(Color.white);
			Font f = new Font("Courier", Font.BOLD, 50);
			g2d.setFont(f);
			g2d.drawString("Appuyer sur entrer", 300, 300);
			g2d.drawRect(10, 250, 1150, 60);
			GradientPaint pausedGrad = new GradientPaint(0, 0, new Color(0, 0, 224, 50), 
					this.getHeight(),this.getWidth() , new Color(0, 0, 224, 50));
			g2d.setPaint(pausedGrad);
			g2d.fill(new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight()));
		}

		if(ctrl.gameOver()) {
			Rectangle2D rect = new Rectangle2D.Double(0, 250,1200,90);
			g2d.setColor(new Color(255,255,255,150));
			g2d.fill(rect);
			g2d.draw(rect);
			g2d.setColor(Color.black);
			Font f = new Font("Courier", Font.BOLD, 50);
			g2d.setFont(f);
			g2d.drawString("GAME OVER", 500, 300);
			g2d.setColor(Color.blue);
			Font f2 = new Font("Courier", Font.BOLD, 20);
			g2d.setFont(f2);
			
			ctrl.setGameInited(false);
			ctrl.setGameInited(false);
		}
	}
}