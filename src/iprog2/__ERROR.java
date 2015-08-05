package iprog2;

public class __ERROR {
	public static void noCanvas () {
		System.out.println("It seems like you have initiated your shape without giving it a canvas object");
		System.out.println("What you probably did: MyShape(x,y,color,NULL)");
		System.out.println("What you should do: MyShape(x,y,color,canvas)");
	}
}
