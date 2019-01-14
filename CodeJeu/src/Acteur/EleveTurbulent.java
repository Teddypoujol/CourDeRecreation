package Acteur;

import java.util.List;

import Acteur.Eleve.Direction;
import Systeme.Cell;
import Systeme.Constant;
import Systeme.Controller;

public class EleveTurbulent extends Eleve {
	
	private List<Eleve> listeEleve;
	private boolean estBagarreur;

	public EleveTurbulent(String nom, int port, int x, int y, boolean b) {
		super(nom, port, x, y);
		estBagarreur = b;
	}
	
	public int choisirAction() {
		//bagarre = 0, bisous = 1, jouer = 2
		int action;
		if(!estBagarreur) {
			action = 1;
		}else action = 0;
		return action;
	}
	
	public Cell deplacement() {

		int x = this.getPosX();	
		int y = this.getPosY();
		int xtmp, ytmp;
		Direction dir= null;
		int i =0;
		Cell c;
		boolean ok = false;
		
		//recherche élève
		do {
			//parcour haut
			do { 
				x--; 
				c = Controller.getInstance().getGrille().getCells()[x][y];
			}while((c.isEmpty() || c.getContent().getClass().getName().equals("Professeur")) && (x>=x-visibilite || x>0));
			if(!c.isEmpty()) {
				dir = Direction.UP;
				ok = true;
			}else i++;
			
			
			//parcour bas
			x = this.getPosX();
			do { 
				x++; 
				c = Controller.getInstance().getGrille().getCells()[x][y];
			}while((c.isEmpty() || c.getContent().getClass().getName().equals("Professeur")) && (x<=x+visibilite || x < Constant.getMapHeight() - 1));
			if(!c.isEmpty()) {
				dir = Direction.DOWN;
				ok = true;
			}else i++;
			
			//parcour gauche
			y = this.getPosY();
			do { 
				y--; 
				c = Controller.getInstance().getGrille().getCells()[x][y];
			}while((c.isEmpty() || c.getContent().getClass().getName().equals("Professeur")) && (y>=y-visibilite || y>0));
			if(!c.isEmpty()) {
				dir = Direction.LEFT;
				ok = true;
			}else i++;
			//parcour droite
			y = this.getPosY();
			do { 
				y++; 
				c = Controller.getInstance().getGrille().getCells()[x][y];
			}while((c.isEmpty() || c.getContent().getClass().getName().equals("Professeur")) && (y<=y+visibilite || y < Constant.getMapWidth()-1));
			if(!c.isEmpty()) {
				dir = Direction.RIGHT;
				ok = true;
			}else i++;
		}while(ok!=true || i>=4);
		
		//déplacement en direction de l'élève trouvé
		if(dir!=null) {
		
			x = this.getPosX();
			y = this.getPosY();
			xtmp = x;
			ytmp = y;
			this.vers = dir;
			
			//HAUT
			if(dir.equals(Direction.UP) && x-portee >= 0) {
				while(xtmp>x-portee && xtmp>0) {
					xtmp--;
				}
			}
			//BAS
			else if(dir.equals(Direction.DOWN) && x+portee < Constant.getMapHeight()) {
				xtmp = x;
				ytmp = y;
				while(xtmp<x+portee & xtmp< Constant.getMapHeight()) {
					xtmp++;	
				}
				
			}
			//GAUCHE
			else if(dir.equals(Direction.LEFT) && y-portee >= 0) {
				xtmp = x;
				ytmp = y;
				while(ytmp>y-portee & ytmp > 0) {
					ytmp--;
				}
			}
			//DROITE
			else if((dir.equals(Direction.RIGHT)) && y+portee < Constant.getMapWidth() ) {
				xtmp = x;
				ytmp = y;
				while(ytmp<y+portee && y < Constant.getMapWidth()) {
					ytmp++;
				}
			}	
			
			Cell test = Controller.getInstance().getGrille().getCells()[xtmp][ytmp];
			if(test.isEmpty()) {
				c = test;
				this.setPosX(x);
				this.setPosY(y);
			}
		}else {
			super.deplacement();
		}
		return c;
	}
}
