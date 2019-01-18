package Interface;



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JFrame;

import Systeme.Controller;

public class Fenetre extends JFrame{
	private static final long serialVersionUID = 1L;

	public Fenetre(int w, int h)
	{
		this.setTitle("Cour de récréation !");
		this.setSize(w, h);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				Controller.getInstance().setGameInited(false);
				Controller.getInstance().setGameStarted(false);
				Controller.getInstance().setGameover(true);
				
			}
		});
		//add(ConsolePanneau());
		

		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
