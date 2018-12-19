package Personne;

public abstract class Personne {
	private int id;
	private String nom;
	
	private int pos_x, pos_y;
	private int visibilite;
	
	public Personne(int id, String nom, int x, int y, int visibilite) {
		this.id = id;
		this.nom = nom;
		pos_x = x;
		pos_y = y;
		this.visibilite = visibilite;
	}
}
