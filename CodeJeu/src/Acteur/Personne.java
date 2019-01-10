package Acteur;

public abstract class Personne {
	private int id;
	private String nom;
	private int visibilite;
	
	public Personne(int id, String nom, int visibilite) {
		this.id=id;
		this.nom=nom;
		this.visibilite=visibilite;
	}

	

	public int getVisibilite() {
		return visibilite;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

}
