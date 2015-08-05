package iprog2;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shapes implements Item {
	//Inherited fields: x,y, color,visible
	protected int size;

	public Square( int x, int y, int size, Color color,Canvas canvas) {
		super(x,y,color,canvas);
		this.size = size;
	}

	public void draw(Graphics g) {
		if (visible) {
			if (color!=null) 
				g.setColor(color);
			g.drawRect(x, y, size, size);
		}
	}
	public void draw(Graphics g, boolean fill) {
		if (visible) {
			draw(g);
			if (fill)
				g.fillRect(x, y, size, size);
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
