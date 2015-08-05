package iprog2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	protected Canvas canvas = new Canvas();
	private static Color BACKGROUND_COLOR = _CONFIG.FRAME_BG_COLOR;
	
	public static void main(String[] args) {
		new MyFrame();
	}

	public MyFrame() throws HeadlessException {
		super(_CONFIG.FRAME_NAME);
		
		setupUI();
		makeThings();
		changeThings();
		pack();
	}
	
	private void makeThings() {
		// Add Initial Items Here
		canvas.addNewItem(new Square(0,0,20, Color.DARK_GRAY, canvas));
		
		// Add an Item after 3 seconds
		// This is an Anonymous class. The idea is: override some of the default's class methods.
		new MyCanvasAdjustingInterval(canvas,3000,1) {
			@Override
			protected void actualActionsBefore() {
				System.out.println("actions before sleeping..from anonymous class");
			}
			@Override
			protected void actualActionsAfter() {
				System.out.println("actions after sleeping from anonymous class");
				canvas.addNewItem(new Square(MathExtra.randomInRange(50, 300),
											MathExtra.randomInRange(50, 700),
											MathExtra.randomInRange(50, 100), Color.GREEN, canvas));
			}
		}.start();

		// Add every 1 second beginning from now, 5 Circles.
		new MyCanvasAdjustingInterval(canvas,1000 ,5) {
			@Override
			protected void actualActionsBefore() {
				System.out.println("actions before sleeping..from anonymous class");
				canvas.addNewItem(new Circle(MathExtra.randomInRange(50, 300),
						MathExtra.randomInRange(50, 700),
						MathExtra.randomInRange(50, 100), Color.RED, canvas));
			}
			@Override
			protected void actualActionsAfter() {
				System.out.println("actions after sleeping from anonymous class");

			}
		}.start();
				
	}
	
	public void changeThings(){
		new MyCanvasAdjustingInterval(canvas, 1500 ,null) {
			@Override
			protected void actualActionsBefore() {
			}
			@Override
			protected void actualActionsAfter() {
				System.out.println("moving guys");
				canvas.moveAll(10,0);
			}
		}.start();
	}
	
	private void setupUI() {
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Let's give our pane some life:
		getContentPane().setBackground(BACKGROUND_COLOR);
		//add the canvas on the field..
		getContentPane().add(canvas);
		
		//now we gonna need a panel to add some buttons on that panel
		JPanel panel = new JPanel();
		//Let's make all our additions from left to right
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//and then add a label on our panel. We don't need a reference for some text, right?  
		//so let's make it anonymous.
		panel.add(new JLabel("Select an action: "));
		
		// now let's give our user some options
		String [] options = {"clear", "create random"};
		//it would be nice to have a way to refer to that UI element so let's give it a name.
		JComboBox combo = new JComboBox(options);
		//now this class implements an ActionListener class. That means that it has implemented somewhere
		//an actionPerformed method. Let's make this method respond when action takes place on our combo  
		combo.addActionListener(this);
		
		// add that shit in the panel 
		panel.add(combo);
		
		// some more anonymous text
		panel.add(new JLabel("Radius: "));
		// an input field with a name so we can grab it's content later on.
		JTextField myInput = new JTextField(10);
		panel.add(myInput);
		// and a button.
		JButton submitButton = new JButton("Perform an action button"); 
		panel.add(submitButton);
		// now let's add a listener to listen for clicks on that button
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					//Thats great. We made an Anonymous class that implements ActionListener 
					//just for that button. so let's add some functionality when it's clicked 
					String radiusUnparsed = myInput.getText().toString();
					int radius = Integer.parseInt(radiusUnparsed);
				
					canvas.addNewItem( new Circle( MathExtra.randomInRange(20, 100), 
																MathExtra.randomInRange(20, 100),
																radius, Color.BLACK, canvas));
			}		
		});
		
		//Let's add a listener on our button 
		
		
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton myButton = new JButton("SHOW ME TOTAL CIRCLES");
		
		JLabel myLabel = new JLabel("output text");
		
		myButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				 myLabel.setText(""+canvas.numberOfItems());
				 myButton.setBackground(Color.BLACK);
				 System.out.println("button clicked");
			};
		});
		panel2.add(myLabel);
		panel2.add(myButton);
		panel2.add(new JTextArea("That's a textarea :-)"));
		getContentPane().add(panel2, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		JComboBox combo = (JComboBox)ev.getSource();
		
		switch (combo.getSelectedItem().toString()) {
		case "clear":
			System.out.println("clear picked");
			canvas.resetCanvas();
			break;
		case "create random":
			System.out.println("creating random");
			canvas.addRandomCircle();
			break;	
		}
		canvas.repaint();
	}
}
