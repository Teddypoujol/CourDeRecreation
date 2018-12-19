package Personne;

public class Professeur extends Personne {
	
	private int patience;
	private int anciennete;
	
	public Professeur(int id, String nom, int x, int y, int visibilite, int patience, int anciennete) {
		super(id, nom , x, y, visibilite);	
		this.patience = patience;
		this.anciennete = anciennete;
	}
	
	public int verifPatience() {
		int etatProf = 0;
		if(patience <= 10)etatProf = 1;
		if(patience == 0) etatProf = 2;
		
		return etatProf;
	}
	
	public boolean verifAnciennete() {
		boolean ancienneteProf = false;		
		if(anciennete >= 20) ancienneteProf = true;
		return ancienneteProf;
	}
	

	public void majPatience(int action) {
		switch (action) {
	        case 1:  patience = patience - 3; //bagarre
	                 break;
	        case 2:  patience = patience + 1; //bisous
	                 break;
	        case 3:  patience = patience - 10; //embete professeur
	                 break;
	        case 4:  patience = patience - 1; //pleure
	                 break;
	        default:
	                 break;
		}
	}
	
	public void addAnciennete() {
		anciennete += 1;
	}
}
