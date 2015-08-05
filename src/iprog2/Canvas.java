package iprog2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Canvas extends JLabel implements MouseListener,KeyListener{
	
	private int SIZE_X= _CONFIG.CANVAS_X_SIZE;
	private int SIZE_Y= _CONFIG.CANVAS_Y_SIZE;
	//private Color BACKGROUND_COLOR = _CONFIG.CANVAS_BG_COLOR;	
	private ArrayList<Item> myItems;

	public Canvas() {
		//this.setOpaque(true);
		//this.setBackground(BACKGROUND_COLOR);	
		this.setFocusable(true);
		

		setPreferredSize(new Dimension(SIZE_X,SIZE_Y));
		
		addMouseListener(this);
		addKeyListener(this);
		myItems = new ArrayList<Item>();
		
		
	}

	
	public void paint(Graphics g){
		for (Item item : myItems) {			
			item.draw(g);
		}
	}
	

	
	
	/******** CREATION METHODS ********/
	public void addRandomCircle() {
		int rad = MathExtra.randomInRange(50, 100);
		int x = MathExtra.randomInRange(rad, SIZE_X-rad);
		int y = MathExtra.randomInRange(rad, SIZE_Y-rad);
		Color clr = new Color( MathExtra.randomInRange(0, 255), MathExtra.randomInRange(0, 255), MathExtra.randomInRange(0, 255));
		
		myItems.add(new Circle(x,y,rad, clr, this));
		repaint();	
	}
	public void addNewItem(Item item) {
		myItems.add(item);
		repaint();	
	}
	/******** REMOVAL METHODS ********/
	public void removeLastItem() {
		if (myItems.size()>0) {
			myItems.remove( myItems.size() - 1); 
			repaint();
		}
	}
	public void removeFirstItem() {
		if (myItems.size()>0) {
			myItems.remove( 0); 
			repaint();
		}
	}
	public void resetCanvas() {
		myItems.clear();
		repaint();	
	}
	/******** MOVE METHODS ********/
	public void moveAll(int x,int y) {
		for (Item item : myItems) {
			item.move(x,y);
		}
	}
	/******* INFO METHODS *********/
	public int numberOfItems() {
		return myItems.size();
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
			case 'A':
				addRandomCircle();
				break;
			case 'B':
				addNewItem(new Square(MathExtra.randomInRange(50, 300),
						MathExtra.randomInRange(50, 700),
						MathExtra.randomInRange(50, 100), Color.RED, this));
				break;
			case 'F':
				addNewItem(new BlinkingCircle(MathExtra.randomInRange(50, 300),
						MathExtra.randomInRange(50, 700),
						MathExtra.randomInRange(50, 100), Color.RED, this));
				break;
			case 'Z':
				addNewItem(new MovingCircle(MathExtra.randomInRange(50, 300),
						MathExtra.randomInRange(50, 700),
						MathExtra.randomInRange(50, 100), Color.RED, this));
				break;
			case 'L':
				addNewItem(new ChangingSizeSquare(MathExtra.randomInRange(50, 300),
						MathExtra.randomInRange(50, 700),
						20, Color.RED, this));
				break;
			case 'C':
				resetCanvas();
				break;
			default :
				System.out.println("the number that has been pressed is not handled :" + e.getKeyChar());
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		this.requestFocus();
		// Add Items when mouse Clicked
		// addNewItem(new Circle(30,30,10,Color.RED,canvas));
		// Or remove items, for example the last one added 
		// removeLastItem();
		// Or everything
		// resetCanvas();
		switch (ev.getButton())
		{
		case MouseEvent.BUTTON3: //Right click to remove first item 
			removeFirstItem();
			break;
		case MouseEvent.BUTTON1: //left click to add a square
			addNewItem(new Square(ev.getX(),ev.getY(),30,Color.RED,this));
			break;
		}
			
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {	
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	@Override 
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
