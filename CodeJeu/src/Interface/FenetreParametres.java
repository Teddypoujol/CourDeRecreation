package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
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


public class FenetreParametres extends JFrame {
	private static final long serialVersionUID = 1L;


	public FenetreParametres() {
		Controller.getInstance().setGameInited(false);
		setBounds(100,100, 750, 500);
		setTitle("La cour de récréation");
		Panel panneau= new Panel();
		panneau.setBackground(Color.GRAY);
		panneau.setPreferredSize(new Dimension(750, 80));
		add(panneau, BorderLayout.NORTH);

		Panel_Parameters pann_param = new Panel_Parameters();
		pann_param.setBackground(Color.GRAY);
		//pann_param.setBorder(BorderFactory.createLineBorder(Color.RED));
		pann_param.setPreferredSize(new Dimension(100,100));
		add(pann_param, BorderLayout.CENTER);

		Panel_img_sud pann_sud = new Panel_img_sud();
		pann_sud.setPreferredSize(new Dimension(750, 150));
		pann_sud.setBackground(Color.GRAY);
		add(pann_sud, BorderLayout.SOUTH);

		Panel_img_ouest pann_ouest = new Panel_img_ouest();
		pann_ouest.setPreferredSize(new Dimension(260, 450));
		pann_ouest.setBackground(Color.GRAY);
		add(pann_ouest, BorderLayout.WEST);
		this.toFront();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private class Panel extends JPanel {
		private static final long serialVersionUID = 1L;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.BLACK);
			Font f = new Font("Courier", Font.BOLD, 14);
			g2.setFont(f);
	
			FontMetrics fm = g.getFontMetrics();
			int hauteur = fm.getHeight();
			g2.drawString("Entrez le nombre d'élèves (max 40) et d'élèves turbulents et de professeurs", 20, 20+hauteur);
			g2.setColor(Color.red);
			f = new Font("Courier", Font.BOLD, 15);
			g2.setFont(f);
			
		}
	}

	private class Panel_img_sud extends JPanel {
		private static final long serialVersionUID = 1L;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			String fichier = Constant.getPathEnfant();
			try {
				BufferedImage im = ImageIO.read(getClass().getResource(fichier));
				g2.drawImage(im, 150, 10, 400, 140, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private class Panel_img_ouest extends JPanel {
		private static final long serialVersionUID = 1L;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			String fichier = Constant.getPathEnfant2();
			try {
				BufferedImage im = ImageIO.read(getClass().getResource(fichier));
				g2.drawImage(im, 10, 10, 220, 220, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private class Window_popup extends JFrame {
		private static final long serialVersionUID = 1L;
		public Window_popup() {
			this.setTitle("ERREUR");
			this.setBounds(500, 250, 500, 280);
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
				g2.setColor(Color.yellow);
				Font f = new Font("Courier", Font.BOLD, 20);
				g2.setFont(f);
				g2.drawString("ERREUR", 10, 30);
				String fichier = Constant.getPathErrorGif();
				try {
					BufferedImage im = ImageIO.read(getClass().getResource(fichier));
					g2.drawImage(im, 120, 40, 180, 200, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
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
			GridLayout gl = new GridLayout(4,1);
			this.setLayout(gl);
			gl.setHgap(40);
			gl.setVgap(50);

			eleve_label = new JLabel("Nombre d'élèves :");
			prof_label = new JLabel("Nombre de professeurs :");
			eleveturbu_label = new JLabel("Nombre d'élèves turbulents : ");

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

			add(lancer, BorderLayout.SOUTH);
			StartAction startAct = new StartAction();
			lancer.addActionListener(startAct);
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

				Controller.getInstance().setIhm(true);
				if(eleves_param != -1 && 
						profs_param!= -1 && 
						elevest_param  != -1 && 
						sumActors <= Constant.getMapWidth() * Constant.getMapHeight()) {
					try {
						Controller.getInstance().setNbProf(profs_param);
						Controller.getInstance().setNbEleves(eleves_param);
						Controller.getInstance().setNbElevesT(elevest_param);
						Controller.getInstance().init(true);
						Controller.getInstance().setGameInited(true);
						Controller.getInstance().setGameStarted(false);
						JFrame win = (JFrame) Controller.getInstance().getFenetre();
						win.setBounds(0, 0, 
						Constant.getMapWidth() * 60, 
						Constant.getMapHeight() * 60+35);
						win.setResizable(false);
					} catch (IOException e) {
						e.printStackTrace();
					}		
				} else {
					new Fenetre(20,20);
				}
			}	
		}
	}
}