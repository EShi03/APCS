import java.awt.*;
import javax.swing.JFrame;

public class Circles {

	boolean lifeStatus;
	int posX;
	int posY;
	
	//Parent class for Happy, Mho
	
	//parent constructor, starting positions are mulitiplied by 60 because that is our scale
	public Circles(boolean lifeStatus, int startPosX, int startPosY) {
		this.lifeStatus = lifeStatus;
		this.posX = startPosX*60;
		this.posY = startPosY*60;	
	}
	
	//setter for lifestatus
	public void setLife(boolean newStatus) {
		 lifeStatus = newStatus;
	}
	
	//setter for changing positions by inputing difference
	public void changePos(int PosXDifference, int PosYDifference) {
		this.posX = posX + PosXDifference*60;
		this.posY = posY + PosYDifference*60;
	}
	
	//setter for changing positions by inputing new coordinate values
	public void setPos(int newPosX, int newPosY) {
		this.posX = newPosX*60;
		this.posY = newPosY*60;
	}
	
	//getter for x position
	public int getXPos() {
		return this.posX;
	}
	
	//getter for y position
	public int getYPos() {
		return this.posY;
	}
	

}
