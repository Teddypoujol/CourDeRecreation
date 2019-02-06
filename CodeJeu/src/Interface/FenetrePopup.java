package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Systeme.*;
public class FenetrePopup extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetrePopup() {
		this.setTitle("ERREUR");
		this.setBounds(500, 250, 200, 200);
		Panel_popup pan_pop = new Panel_popup();
		pan_pop.setBackground(new Color(255,0,0,200));
		this.add(pan_pop);
		this.toFront();
		this.setVisible(true);
	}

	private class Panel_popup extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.RED);
			Font f = new Font("Courier", Font.BOLD, 20);
			g2.setFont(f);
			g2.drawString("ERREUR", 10, 30);
			String fichier = Constant.getPathErreur();
			try {
				BufferedImage im = ImageIO.read(getClass().getResource(fichier));
				g2.drawImage(im, 0, 0, 200, 200, null);
				g2.drawString("ERREUR", 10, 30);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
