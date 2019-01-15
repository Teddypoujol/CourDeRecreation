package Lancement;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Choixmode extends JFrame {
	private static final long serialVersionUID = 1L;

	public Choixmode() {
		super();
		this.setTitle("Choisir le mode");
		this.setBounds(500, 250, 500, 280);
		PanelTitle title = new PanelTitle();
		title.setPreferredSize(new Dimension(500, 50));
		this.add(title, BorderLayout.NORTH);
		PanelChooseMode pan = new PanelChooseMode();
		pan.setPreferredSize(new Dimension(500, 50));
		this.add(pan, BorderLayout.CENTER);
		this.toFront();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}

	@SuppressWarnings("serial")
	private class PanelTitle extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.BLACK);
			Font f = new Font("Courier", Font.BOLD, 20);
			g2.setFont(f);
			g2.drawString("Choissisez le mode", 150, 30);
		}
	}

	private class PanelChooseMode extends JPanel {
		private static final long serialVersionUID = 1L;
		JButton console_button;
		JButton ihm_button;

		public PanelChooseMode() 
		{
			console_button = new JButton("CONSOLE");
			ihm_button = new JButton("GRAPHIQUE");
			add(console_button, BorderLayout.SOUTH);
			add(ihm_button, BorderLayout.SOUTH);
			console_button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Client.launcher = new Console();
					console_button.removeActionListener(this);
					Choixmode.this.dispose();
				}
			});

			ihm_button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Client.launcher = new Graphique();
					ihm_button.removeActionListener(this);
					Choixmode.this.dispose();
				}
			});
		}
	}
}