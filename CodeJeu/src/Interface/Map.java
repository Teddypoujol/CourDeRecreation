package Interface;

import java.awt.BorderLayout;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Acteur.*;
import Systeme.*;
/**
 * classe de Map dessine la cour de cecreation
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Tileset
 * @version 2.0
 */
public class Map extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Controller ctrl = Controller.getInstance();
	
	/**
	 * Constructeur de Map, lance le jeu si on appuie sur entree ou f5
	 * 
	 */
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

	/**
	 *@param g Le graphique 
	 * Permet de conserver le graphique et de le dessiner dans un panneau
	 * ce paintComponent dessine un tile selon l'element de jeu sur chaque case ou dessine un terrain.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		try {
			for(int i = 0; i < this.ctrl.getGrille().getLi(); i++) {
				for(int j = 0; j < this.ctrl.getGrille().getCo(); j++) {
					
					//System.out.println(i + "  " + j +"  "+ this.ctrl.getGrille().getCells()[i][j].isEmpty());
					Image courimg= ImageIO.read(getClass().getResource(Constant.getPathCour()));
					g.drawImage(courimg,j*60,i*60,(j+1)*60,(i+1)*60,0,0,60,60,Controller.getInstance().getMap());
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
			
			for(JeuxTerrain jt : this.ctrl.getJeuxTerrain()) 
			{
				jt.draw(g2d, jt.getPosX(), jt.getPosY());
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(!ctrl.isGameStarted()) {
			g2d.setColor(Color.GREEN);
			Font f = new Font("Joker", Font.BOLD, 50);
			g2d.setFont(f);
			g2d.drawString("Appuyez sur entrer",175, 300);
			g2d.drawRect(10, 250,850, 60);
			GradientPaint pausedGrad = new GradientPaint(0, 0, new Color(0, 200, 100, 50), 
					this.getHeight(),this.getWidth() , new Color(0, 0, 228, 50));
			g2d.setPaint(pausedGrad);
			g2d.fill(new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight()-15));
		}

		if(ctrl.gameOver()) {
			Rectangle2D rect = new Rectangle2D.Double(0, 250,1200,90);
			g2d.setColor(new Color(255,255,255,150));
			g2d.fill(rect);
			g2d.draw(rect);
			g2d.setColor(Color.black);
			Font f = new Font("Corbel", Font.BOLD, 50);
			g2d.setFont(f);
			
			List<Professeur> profs;
			profs = ctrl.getProfesseurs();
			
			List<Eleve> eleves;
			eleves = ctrl.getEleves();
			
			
			List<EleveTurbulent> elevest;
			elevest = ctrl.getElevesT();
			
			int sum = ctrl.getNbEleves() + ctrl.getNbElevesT();
			if(profs.isEmpty())
			{
				g2d.drawString("Les professeurs ont perdu !!", 50, 300);
				
				
			}
			else if(sum <= 1)
			{
				g2d.drawString("Les élèves sont tous punis !!", 0, 300);
			}
			else
			{
				g2d.drawString("La récréation est fini !", 100, 300);
				
			}
			g2d.setColor(Color.blue);
			Font f2 = new Font("Corbel", Font.BOLD, 20);
			g2d.setFont(f2);
			
			ctrl.setGameInited(false);
			ctrl.setGameInited(false);
		}
	}
}