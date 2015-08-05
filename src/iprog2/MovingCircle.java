package iprog2;

import java.awt.Color;

public class MovingCircle extends Circle {
	int stepsOnX = 10;
	int stepsOnY = 3;
	public MovingCircle(int x, int y, int rad, Color color, Canvas canvas, Integer pauses) {
		super(x, y, rad, color, canvas);

		new MyCanvasAdjustingInterval(canvas, pauses,null){
			@Override
			protected void actualActionsBefore() {
				//Leave this empty if you don't want to inherit any behavior
				// from parents
			}
			@Override
			protected void actualActionsAfter() {
				setX(getX()+stepsOnX);
				setY(getY()+stepsOnY);
				asyncUpdateCanvas();
			}
		}.start() ;	
		
	}
	public MovingCircle(int x, int y, int rad, Color color, Canvas canvas) {
		this(x,y,rad,color,canvas,1000); //Calling an already made constructor with a default break = 1s
	}

}
