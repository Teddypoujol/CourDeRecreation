package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JTextArea;


//import Merde.Panneau2.settatie;

import Systeme.*;
import java.awt.Font;
import javax.swing.JButton;
//from   ww  w .jav  a2  s . c  o m





public class ConsolePanneau extends JPanel implements ActionListener
{
	JButton accelerer = new JButton("Accelerer");
	JButton ralentir = new JButton("Ralentir");
	JButton pause = new JButton("Pause");
	
	JTextArea textArea = new JTextArea(0, 0);
	public ConsolePanneau() {
	    /*
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
	  */
		
		accelerer.setBounds(100,100,10,20);
		ralentir.setBounds(200,200,10,20);
		
		accelerer.addActionListener(this);
		add(accelerer);
		pause.addActionListener(this);
		add(pause);
		ralentir.addActionListener(this);
		add(ralentir);
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		int x = Controller.getInstance().getVitesse();
		if(source==accelerer)
		{
			
			if(x<=100)
			{
				Controller.getInstance().setVitesse(100);
			}
			else
			{
				Controller.getInstance().setVitesse(x-100);
			}
		}
		else if(source == ralentir)
		{
			
			if(x>=3000)
			{
				Controller.getInstance().setVitesse(3000);
			}
			else
			{
				Controller.getInstance().setVitesse(x+100);
			}
		}
		else if(source == pause)
		{
			Controller.getInstance().setPause();
			
		}
		
		
		
	}
	
	
	 
	
	
}
