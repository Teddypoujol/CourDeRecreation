package Interface;



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JFrame;
import Systeme.Controller;

/**
 * Classe permettant que creer une fenetre
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Elementdejeu
 * @version 2.0
 */


public class Fenetre extends JFrame{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur de Fenetre
	* @param w la largeur de la fenetre
	* @param h la hauteur de la fenetre
	 */
	public Fenetre(int w, int h)
	{
		this.setTitle("Cour de recreation !");
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
	
		

		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
