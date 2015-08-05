package iprog2;

public class MathExtra {
	public static int randomInRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
}
