import java.awt.*;

import javax.swing.JFrame;

import java.awt.Graphics;
public class Flag extends JFrame{
	//Scaling of the flag that doesn't work because
	//I couldn't find the right ratio for star spacing and
	//some weird stripe spacing issue
	final private static int SCALE = 130;
	
	//runs init when create
	public Flag(){
		init();
	}
	
	//sets the size dimensions
	//sets the background color to white
	//repaint, updates the frame by running paint
	public void init(){
		setSize((int)(1.9*SCALE), SCALE);
		setBackground(Color.WHITE);
		repaint();
	}
	
	//runs methods that draw the stripes, blue rectangle, and stars
	public void paint(Graphics g){
		stripes(g);
		starArea(g);
		stars(g);
	}
	
	//sets stripeHeight to 1/13 of the height and stripeWidth to the length of the falg
	private static void stripes(Graphics g){
		int stripeHeight = SCALE/13;
		int stripeWidth = SCALE;
		// i < 15 because there are 7 red stripes in the flag
		// there are seven odd numbers in 15/2 ((15-1)/2 = 7)
		//stripeWidth*2 because I messed up something and I had to hardcode that
		for(int i = 0; i < 15; i++){
			g.setColor(Color.red);
			if(i%2 == 0){
				g.fillRect(0, stripeHeight*i, stripeWidth*2, stripeHeight);
			}
		}
	}
	
	//creates the blue rectangle on the top left
	//only sketchy thing is that it creates the rectangle
	//on the top edge of the bar and not the top visible edge of the white frame
	private static void starArea(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 22, (int)(0.76*SCALE), (int)(7*SCALE/13));
	}
	
	//method that creates stars in appropriate gaps
	private static void stars(Graphics g){
		int starPositionXGap = (int)(0.063*SCALE);
		int starPositionYGap = (int)(0.054*SCALE);
		//j<9 because there are 9 rows of stars
		//the if statement is for alternating between rows that 
		//start indented and not indented
		for(int j = 0; j<9; j++){
			if(j%2 == 0){
				//i<6 because 6 stars in unindented row
				//x is xgap*2(for gap)*i(interval) + 1(starting gap)
				//y is ygap*(j(interval)+4 (hardcode solution))
				for(int i = 0; i<6; i++){
					createStar(starPositionXGap*(2*i+1),(int)(starPositionYGap*(j+4)), g);
				}
			}
			else {
				for(int i = 0; i<5; i++){
					//i<5 because 5 stars in indented row
					//the rest is the same as above except the starting gap is 2
					createStar(starPositionXGap*(2*i+2),(int)(starPositionYGap*(j+4)), g);
				}
			}
		}
	}
	
	//method to create a star
	private static void createStar(int x, int y, Graphics g){
		// int arrays to hold xpoints and ypoints for the outer
		//and inner points of a star
		int[] xPoints = new int[10];
		int[] yPoints = new int[10];
		int[] xPointsInner = new int[5];
		int[] yPointsInner = new int[5];
		int starPointLength = (int)(0.0616/2*SCALE);
		//Geometry I did on paper and just typed in my answer
		int starDiagonalLength = (int)((starPointLength/(Math.tan(36*Math.PI/180)+Math.tan(18*Math.PI/180))*Math.tan(36*Math.PI/180))/Math.cos(36*Math.PI/180))/2-2;
		//filling in arrays with the points using trig
		//find the angle*pi/180 (radians to angle) *radius of star + x/y position
		//I alternated the points filling into the array in order so that fillPolygon
		//draws the shape in the correct order
		for(int i = 0; i<10; i++){
			if(i%2 == 0){
				xPoints[i] = (int)(Math.sin((108 + 72*i)*Math.PI/180)*starPointLength + x);
				yPoints[i] = (int)(Math.cos((108 + 72*i)*Math.PI/180)*starPointLength + y);
				xPointsInner[i/2] = (int)(Math.sin((144 + 72*i/2)*Math.PI/180)*starDiagonalLength + x);
				yPointsInner[i/2] = (int)(Math.cos((144 + 72*i/2)*Math.PI/180)*starDiagonalLength + y);
			}
			else{
				xPoints[i] = (int)(Math.sin((144 + 72*i)*Math.PI/180)*starDiagonalLength + x);
				yPoints[i] = (int)(Math.cos((144 + 72*i)*Math.PI/180)*starDiagonalLength + y);
			}
		}
		// first fill polygon makes a star with leaves hexagon in the middle
		// so I made a second polygon which filled the hexagon in the middle
		g.setColor(Color.white);
		g.fillPolygon(xPoints, yPoints, 10);
		g.fillPolygon(xPointsInner, yPointsInner, 5);
	}
}
