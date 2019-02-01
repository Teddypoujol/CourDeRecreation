package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Scrollbar;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JTextArea;


//import Merde.Panneau2.settatie;


import java.awt.Font;
import javax.swing.JButton;
//from   ww  w .jav  a2  s . c  o m





public class ConsolePanneau extends JPanel
{
	JButton b = new JButton("coucou");
	JTextArea textArea = new JTextArea(24, 80);
	public ConsolePanneau() {
	    //JTextArea textArea = new JTextArea(24, 80);
	    textArea.setBackground(Color.BLACK);
	    textArea.setForeground(Color.LIGHT_GRAY);
	    textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
	     
	    System.setOut(new PrintStream(new OutputStream() {
	      @Override
	      public void write(int b) throws IOException {
	        textArea.append(String.valueOf((char) b));
	      }
	    }));
	   
	   
	    add(textArea);
	  
	  }
	 
	
	
}
