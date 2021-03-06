package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Systeme.*;

/**
 * Fenetre parametree permettant de definir la fenetre avec les parametres de l'ihm
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Elementdejeu
 * @version 2.0
 */
public class FenetreParametres extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static FenetreParametres INSTANCE;
	public static FenetreParametres getInstance() 
	{
		if(INSTANCE == null) 
		{
			INSTANCE = new FenetreParametres();
			
		}
		return INSTANCE;
	}
	/**
	 * Constructeur de fenetre ihm permettant de lancer l'ihm
	 */

	public FenetreParametres() {
		Controller.getInstance().setGameInited(false);
		setBounds(100,100, 800,480);
		setTitle("La cour de recreation");
		Panel panneau= new Panel();
		panneau.setBackground(Color.ORANGE);
		panneau.setPreferredSize(new Dimension(500, 80));
		add(panneau, BorderLayout.NORTH);
		Panel_Parameters pann_param = new Panel_Parameters();
		pann_param.setBackground(Color.WHITE);;
		pann_param.setPreferredSize(new Dimension(50,100));
		add(pann_param, BorderLayout.CENTER);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private class Panel extends JPanel {
		private static final long serialVersionUID = 1L;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.BLACK);
			Font f = new Font("Calibri", Font.BOLD, 14);
			g2.setFont(f);
			FontMetrics fm = g.getFontMetrics();
			int hauteur = fm.getHeight()-20;
			g2.drawString("Attention ! nombre d'élèves maximum est de 60 et le nombre de professeurs maximum est de 20", 10, 20+hauteur);
			
			Image profimg;
			Image enfantimg1;
			Image enfantimg2;
		
			
			try {
				
				enfantimg1 = ImageIO.read(getClass().getResource(Constant.getPathEnfantParam1()));
				enfantimg2 = ImageIO.read(getClass().getResource(Constant.getPathEnfantParam2()));
				profimg = ImageIO.read(getClass().getResource(Constant.getPathProf()));
				
				
				
				g2.drawImage(profimg,300,20,Controller.getInstance().getMap());
				g2.drawImage(enfantimg1,100,20,Controller.getInstance().getMap());
				g2.drawImage(enfantimg2,530,20,Controller.getInstance().getMap());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	


	private class Panel_Parameters extends JPanel {
		private static final long serialVersionUID = 1L;

		private JTextField nb_eleves;
		private JTextField nb_profs;
		private JTextField nb_elevesturbu;

		private JLabel eleve_label;
		private JLabel prof_label;
		private JLabel eleveturbu_label;

	
		private JButton lancer;

	
		
		public Panel_Parameters() {
			
			FlowLayout gl = new FlowLayout();
			this.setLayout(gl);
		

			eleve_label = new JLabel("Nombre d'elèves :");
			prof_label = new JLabel("Nombre de professeurs :");
			eleveturbu_label = new JLabel("Nombre d'elèves turbulents : ");
			
			
			

			nb_eleves = new JTextField(3);
			nb_profs= new JTextField(3);
			nb_elevesturbu = new JTextField(3);
		
			
			add(eleve_label);
			add(nb_eleves);
			add(prof_label);
			add(nb_profs);
			add(eleveturbu_label);
			add(nb_elevesturbu);
			
			

			lancer = new JButton("Lancer la partie");
			 lancer.setBackground(Color.cyan);
			 lancer.setForeground(Color.black);
			 lancer.setFocusPainted(true);
			 lancer.setFont(new Font("Tahoma", Font.BOLD, 12));
			 
			add(lancer, BorderLayout.CENTER);
			StartAction startAct = new StartAction();
			lancer.addActionListener(startAct);
			
			
			
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
		
		
			Image ecole;
			
			try {
				ecole = ImageIO.read(getClass().getResource(Constant.getPathBus()));
				
				
				g2.drawImage(ecole,100,60,Controller.getInstance().getMap());
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		private class StartAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String eleves_param_str = nb_eleves.getText();
				String prof_param_str = nb_profs.getText();
				String elevet_param_str = nb_elevesturbu.getText();

				Integer eleves_param = Controller.getInstance().unsigned(eleves_param_str);
				Integer profs_param = Controller.getInstance().unsigned(prof_param_str);
				Integer elevest_param = Controller.getInstance().unsigned(elevet_param_str );

				Integer sumActors = eleves_param + profs_param  + elevest_param ;
				Integer sumEleves= eleves_param + elevest_param ;
				Controller.getInstance().setIhm(true);
				if(eleves_param != -1 && 
						profs_param!= -1 && 
						elevest_param  != -1 && 
						sumEleves <= 60 &&
						profs_param <= 20 
						&&
						sumActors <= Constant.getMapWidth() * Constant.getMapHeight()) {
					try {
						
							Controller.getInstance().setNbProf(profs_param);
							Controller.getInstance().setNbEleves(eleves_param);
							Controller.getInstance().setNbElevesT(elevest_param);
							Controller.getInstance().init(true);
							Controller.getInstance().setGameInited(true);
							Controller.getInstance().setGameStarted(false);
						
						
						
						
					} catch (IOException e) {
						e.printStackTrace();
					}		
				} else {
					new FenetrePopup();
				}
			}	
		}
	}
}