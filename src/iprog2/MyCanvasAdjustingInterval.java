package iprog2;

import java.awt.Color;

public class MyCanvasAdjustingInterval extends Interval {
	public final Canvas canvas;
	
	public MyCanvasAdjustingInterval(Canvas canvas, Integer timeToSleep, Integer repetitions) {
		super(timeToSleep, repetitions);
		this.canvas = canvas;
	}
	
	@Override
	protected void actualActionsBefore() {
		System.out.println("actions before sleeping..from MyCanvasAdjusting");
	}
	@Override
	protected void actualActionsAfter() {
		System.out.println("actions after sleeping from MyCanvasAdjusting");
	}
}
