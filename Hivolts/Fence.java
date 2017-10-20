import java.awt.*;
import javax.swing.JFrame;

	//Both circles die on impact with this object
	//there are fences on the outside of the 
	//gameboard and 20 random electric fences
	//within the game
	
public class Fence {
	private int xPosition;
	private int yPosition;
	
	//Constructor that takes x and y position, times 60 because that is the scale
	public Fence(int xPosition, int yPosition){
		this.xPosition = (xPosition)*60;
		this.yPosition = (yPosition)*60;
	}
	
	//getter for x position
	public int getXPos(){
		return this.xPosition;
	}
	
	//getter for y position
	public int getYPos(){
		return this.yPosition;
	}	
}