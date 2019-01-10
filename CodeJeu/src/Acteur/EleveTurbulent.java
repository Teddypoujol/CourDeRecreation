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
		int i =0;
		Cell c;
		boolean ok = false;
		
		//recherche élève
		do {
			//parcour haut
			do { 
				x--; 
				c = Controller.getInstance().getGrille().getCells()[x][y];
			}while(c.isEmpty() && (x>=x-visibilite || x>0));
			if(!c.isEmpty()) {
				dir = 0;
				ok = true;
			}else i++;

			//parcour bas
			do { 
				x++; 
				c = Controller.getInstance().getGrille().getCells()[x][y];
			}while(c.isEmpty() && (x<=x+visibilite || x < Constant.getMapHeight() - 1));
			if(!c.isEmpty()) {
				dir = 1;
				ok = true;
			}else i++;
			//parcour gauche
			do { 
				y--; 
				c = Controller.getInstance().getGrille().getCells()[x][y];
			}while(c.isEmpty() && (y>=y-visibilite || y>0));
			if(!c.isEmpty()) {
				dir = 2;
				ok = true;
			}else i++;
			//parcour droite
			do { 
				y++; 
				c = Controller.getInstance().getGrille().getCells()[x][y];
			}while(c.isEmpty() && (y<=y+visibilite || y < Constant.getMapWidth()-1));
			if(!c.isEmpty()) {
				dir = 0;
				ok = true;
			}else i++;
		}while(ok!=true || i>=4);
		
		//déplacement en direction de l'élève trouvé
		if(dir!=-1) {
			//HAUT
			if((dir == 0) && x > 0) {
				while(x>=x-portee || x>0) {
					x--;
				}
			}
			//BAS
			else if((dir == 1) && x < Constant.getMapHeight() - 1) {
				while(x<=x+portee || x< Constant.getMapHeight()) {
					x++;	
				}

			}
			//GAUCHE
			else if(dir==2 && y > 0) {
				while(y>=y-portee || y > 0) {
					y--;
				}
			}
			//DROITE
			else if((dir == 3) && y < Constant.getMapWidth() - 1 ) {
				while(y<=y+portee || y < Constant.getMapWidth()) {
					y++;
				}
			}	
		}else {
			super.deplacement();
		}
		return c;
	}
}
