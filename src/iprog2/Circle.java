package iprog2;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shapes implements Item {
	private int rad;
	
	public Circle (int x, int y, int rad, Color color, Canvas canvas) {
		super(x,y,color,canvas);
		this.rad = rad;

	}

	public void draw(Graphics g) {
		if (visible) {
			if (color!=null) 
				g.setColor(color);
			g.drawOval(x-rad, y-rad, 2*rad, 2*rad);
		}
	}
	public void draw(Graphics g, boolean fill) {
		if (visible) {
			draw(g);
			if (fill)
				g.fillOval(x-rad, y-rad, 2*rad, 2*rad);
		}
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}	
}
