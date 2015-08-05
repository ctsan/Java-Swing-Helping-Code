package iprog2;

import java.awt.Color;
import java.awt.Graphics;

public class Shapes {

	protected int x;  //Coordinates
	protected int y;
	protected boolean visible;  // Visibility.
	protected Color color; 	 	// Color: If you want different color for filling and drawing, 
								// add a second color here  
	
	protected Canvas canvas; //We will need this object only if we wish to draw on the canvas Asynchronously.
							 //for example when the shape decides to draw it's current situation immediately
							 //when a timer sends it's signal

	public Shapes( int x, int y,Color color, Canvas canvas) {
		super();
		this.x = x; 	 	
		this.y = y;
		this.visible=true; //default value: our object being visible
		
		//These values may be NULL when you don't care about them
		this.color = color; 
		this.canvas = canvas;
		
		

	}

	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public void toogleVisible() {
		this.visible = !this.visible;
	}

	public void move(int x,int y) {
		this.x+=x;
		this.y+=y;
		asyncUpdateCanvas();
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void asyncUpdateCanvas() {
		try {
			canvas.repaint();
		} catch (NullPointerException e) {
			__ERROR.noCanvas();
		}
	}
}
