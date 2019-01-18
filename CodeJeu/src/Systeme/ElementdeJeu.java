package Systeme;

public abstract class ElementdeJeu implements Drawable{
	private int pos_x;
	private int pos_y;
	
	public ElementdeJeu(int posX, int posY) {
		super();
		this.pos_x = posX;
		this.pos_y = posY;
	}

	public int getPosX() {
		return this.pos_x;
	}

	public void setPosX(int posX) {
		this.pos_x = posX;
	}

	public int getPosY() {
		return this.pos_y;
	}

	public void setPosY(int posY) {
		this.pos_y = posY;
}
}
