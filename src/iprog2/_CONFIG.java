package iprog2;

import java.awt.Color;

public class _CONFIG {
	public static Color CANVAS_BG_COLOR = Color.WHITE; //select null if you don't want to color the canvas
														// we are not using this method to color our canvas because it adds 
														//a delay. Instead we are using FRAME_BG_COLOR constant
	public static int CANVAS_X_SIZE = 700;
	public static int CANVAS_Y_SIZE = 700;
	
	public static int DEFAULT_INTERVAL_PAUSE_IN_MILLIS = 1000; // 1s
	public static Integer DEFAULT_INTERVAL_REPETITIONS = null; //Infinite times 


	public static Color FRAME_BG_COLOR = Color.WHITE;
	public static String FRAME_NAME = "This is your title";
}
