package BikeRiding;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Coin
{
	private  int  x,y;
	private boolean isThere;
	private String imagePath;
	
	public Coin(int x, int y, boolean isThere, String imagePath)
	{
		this.x = x;
		this.y = y;
		this.isThere = isThere;
		this.imagePath = imagePath;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isThere(boolean  b) {
		return isThere;
	}
	public void setThere(boolean isThere) {
		this.isThere = isThere;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void draw(Graphics g)
	{
		ImageIcon ghost = new ImageIcon(imagePath);
		g.drawImage(ghost.getImage(), x, y, null);	
	}
	public boolean isThere() 
	{
		return true;
	}
}
