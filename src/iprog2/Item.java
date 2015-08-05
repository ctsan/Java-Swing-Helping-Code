package iprog2;

import java.awt.Graphics;

public interface Item {
	public void draw(Graphics g);
	
	public boolean isVisible();
	public void setVisible(boolean visible);

	public void move(int x,int y);
}
