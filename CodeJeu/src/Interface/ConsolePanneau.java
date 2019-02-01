package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JTextArea;




public class ConsolePanneau extends JPanel
{
	JTextArea textArea ;
	public ConsolePanneau()
	{
		
		super();
		textArea = new JTextArea(24, 80);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.LIGHT_GRAY);
		
		 
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g.drawRect(200, 200, 200, 500);
		
	}
	
}
