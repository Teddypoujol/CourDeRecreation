package Personne;

public abstract class Personne {
	private int id;
	private String nom;
	
	private int pos_x, pos_y;
	private int visibilite;
	
	public Personne(int id, String nom, int x, int y, int visibilite) {
		this.id=id;
		this.nom=nom;
		setPos_x(x);
		setPos_y(y);
		this.visibilite=visibilite;
	}

	public int getPos_x() {
		return pos_x;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
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
