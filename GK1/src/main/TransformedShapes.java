package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;


public class TransformedShapes extends JPanel {

	//------- For drawing ONLY while paintComponent is being executed! --------

	private Graphics2D g2; // A copy of the graphics context from paintComponent.

	/**
	 * Removes any transformations that have been applied to g2, so that
	 * it is back to the standard default coordinate system.
	 */
	private void resetTransform() {
		g2.setTransform(new AffineTransform());
	}

	/**
	 * Draws a filled square with side 100 centered at (0,0), subject
	 * to whatever transform(s) have been applied to g2.
	 */
	private void square() {
		g2.fillRect(-50,-50,100,100);
	}

	/**
	 * Draws a filled circle of radius 50 (diameter 100) centered at (0,0), 
	 * subject to whatever transform(s) have been applied to g2.
	 */
	private void circle() {
		g2.fillOval(-50,-50,100,100);
	}
	
	/**
	 * Draws a filled triangle with vertices at (-50,50), (50,50), and 
	 * (0,-50), subject to whatever transform(s) have been applied to g2.
	 */
	private void triangle() {
		g2.fillPolygon(new int[] {-50,50,0}, new int[] {50,50,-50}, 3);
	}
	

	//-----------------------------------------------------------------------------------


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// TODO Draw the required image, using ONLY the four methods defined above, 
		// along with g2.setColor, g1.scale, g2.translate, and g2.rotate.

		/* ----------------------------------------------------------------------- */
		
		// REMOVE THE FOLLOWING CODE, which draws a big red X in the upper right quadrant,
		// and insert your own code to draw the required pictures in the four quadrants.

		// The next two line scale the X to be twice the original size
		// and then moves the center of the X from (0,0) to (450,150).

		//g2.translate(450,150);
		//g2.scale(2,2);

		// Set the drawing color to red.

		//g2.setColor(Color.RED);

		// The next three lines draw a tilted rectangle centered at (0,0).

		//g2.rotate(Math.PI/4);
		//g2.scale(1,0.25);
		//square();

		// The next two lines undo the previous scale and rotation.  (Can't use resetTransform()
		// here because that would also eliminate the first translate and scale.)

		//g2.scale(1,4);
		//g2.rotate(-Math.PI/4);

		// The next three lines draw a rectangle tilted in the opposite direction.

		//g2.rotate(-Math.PI/4);
		//g2.scale(1,0.25);
		//square();

		// reset the transform, so changes don't apply to subsequent drawing

		//resetTransform();
		
		//----------kolko z kwadratem------------------------------------------------
		g2.translate(150,150);
		g2.scale(2,2);
		g2.setColor(Color.BLACK);
		g2.scale(1,1);
		circle();
		resetTransform();
		
		g2.translate(150,150);
		g2.scale(2,2);
		g2.setColor(Color.YELLOW);
		g2.scale(0.5,0.5);
		square();
		resetTransform();
		
		//----------zielone marlboro------------------------------------------------
		g2.translate(400,150);
		g2.scale(2,2);
		g2.setColor(Color.GREEN);
		g2.rotate(Math.PI/2);
		g2.scale(1,0.5);
		triangle();
		resetTransform();
		
		g2.translate(450,100);
		g2.scale(2,2);
		g2.setColor(Color.GREEN);
		g2.rotate(Math.toRadians(180));
		g2.scale(1,0.5);
		triangle();
		resetTransform();
		
		g2.translate(500,150);
		g2.scale(2,2);
		g2.setColor(Color.GREEN);
		g2.rotate(Math.toRadians(270));
		g2.scale(1,0.5);
		triangle();
		resetTransform();
		
		//----------mucha------------------------------------------------
		g2.translate(150,450);
		g2.scale(1.5,1.5);
		g2.setColor(Color.BLUE);
		g2.rotate(Math.PI/2);
		g2.scale(0.5,1);
		square();
		resetTransform();
		
		g2.translate(150,375);
		g2.scale(1.5,1.5);
		g2.setColor(Color.BLUE);
		g2.rotate(Math.toRadians(180));
		g2.scale(0.5,0.5);
		triangle();
		resetTransform();
		
		g2.translate(150,525);
		g2.scale(1.5,1.5);
		g2.setColor(Color.BLUE);
		g2.rotate(Math.toRadians(360));
		g2.scale(0.5,0.5);
		triangle();
		resetTransform();
		
		//----------zorro pozna porro------------------------------------------------
		
		g2.translate(450,560);
		g2.scale(10,1);
		g2.setColor(Color.RED);
		g2.rotate(Math.PI/2);
		g2.scale(0.1,0.2);
		square();
		resetTransform();
		
		g2.translate(450,450);
		g2.scale(0.1,0.1);
		g2.setColor(Color.RED);
		g2.rotate(Math.toRadians(133));
		g2.scale(29,1);
		square();		
		resetTransform();

		
		g2.translate(450,345);
		g2.scale(10,1);
		g2.setColor(Color.RED);
		g2.rotate(Math.PI/2);
		g2.scale(0.1,0.2);
		square();
		resetTransform();
		

		
		/* ----------------------------------------------------------------------- */
		
	} // end paintComponent()


	//--------------------------------------------------------------------------------------

	public TransformedShapes() {
		setPreferredSize(new Dimension(600,600) );
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
	}

	public static void main(String[] args)  {
		JFrame window = new JFrame("Drawing With Transforms");
		window.setContentPane(new TransformedShapes());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}