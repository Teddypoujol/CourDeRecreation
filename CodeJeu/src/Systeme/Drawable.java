package Systeme;


import java.awt.Graphics;
import java.io.IOException;


public interface Drawable 
{
	void draw(Graphics g, int x, int y) throws IOException;
}
