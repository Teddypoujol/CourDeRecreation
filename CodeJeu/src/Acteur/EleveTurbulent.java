package Acteur;

import java.util.List;

import Systeme.Cell;
import Systeme.Constant;
import Systeme.Controller;

public class EleveTurbulent extends Eleve {
	
	private List<Eleve> listeEleve;

	public EleveTurbulent(String nom, int port, int x, int y, boolean estBagarreur) {
		super(nom, port, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Cell Deplacement() {

		int x = this.getPosX();	
		int y = this.getPosY();
		int dir=-1;
		int i=0;
		Cell c = Controller.getInstance().getGrille().getCells()[x][y];
		boolean ok = false;
		
		//recherche élève
		do {
			//parcour haut
			do { x--; }while(c.isEmpty() && (x>=x-visibilite || x>0));
			if(!c.isEmpty()) {
				dir = 0;
				ok = true;
			}
			
			//parcour bas
			do { x++; }while(c.isEmpty() && (x<=x+visibilite || x < Constant.getMapHeight() - 1));
			if(!c.isEmpty()) {
				dir = 1;
				ok = true;
			}
			
			//parcour gauche
			do { y--; }while(c.isEmpty() && (y>=y-visibilite || y>0));
			if(!c.isEmpty()) {
				dir = 2;
				ok = true;
			}
			
			//parcour droite
			do { y++; }while(c.isEmpty() && (y<=y+visibilite || y < Constant.getMapWidth()-1));
			if(!c.isEmpty()) {
				dir = 0;
				ok = true;
			}
		}while(ok!=true);
		
		//déplacement en direction de l'élève trouvé
		if(dir!=-1) {
			
		}else {
			super.deplacement();
		}	
	}
}
