package iprog2;

import java.awt.Color;

public class ChangingSizeSquare extends Square {
	
	public ChangingSizeSquare(int x, int y, int rad, Color color, Canvas canvas, Integer pauses) {
		super(x, y, rad, color, canvas);

		new MyCanvasAdjustingInterval(canvas, pauses,null){
			@Override
			protected void actualActionsBefore() {
				//Leave this empty if you don't want to inherit any behavior
				// from parents
			}
			@Override
			protected void actualActionsAfter() {
				toogleSize();
				asyncUpdateCanvas();
			}
		}.start() ;	
		
	}
	public ChangingSizeSquare(int x, int y, int rad, Color color, Canvas canvas) {
		this(x,y,rad,color,canvas,1000); //Calling an already made constructor with a default break = 1s
	}
	
	public void toogleSize(){
		if (getSize()==20) setSize(40);
		else setSize(20);
	}
}
