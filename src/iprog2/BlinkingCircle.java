package iprog2;

import java.awt.Color;

public class BlinkingCircle extends Circle {
	
	public BlinkingCircle(int x, int y, int rad, Color color, Canvas canvas, Integer pauses) {
		super(x, y, rad, color, canvas);

		new MyCanvasAdjustingInterval(canvas, pauses,null){
			@Override
			protected void actualActionsBefore() {
				//Leave this empty if you don't want to inherit any behavior
				// from parents
			}
			@Override
			protected void actualActionsAfter() {
				toogleVisible();
				asyncUpdateCanvas();
			}
		}.start() ;	
		
	}
	public BlinkingCircle(int x, int y, int rad, Color color, Canvas canvas) {
		this(x,y,rad,color,canvas,1000); //Calling an already made constructor with a default break = 1s
	}

}
