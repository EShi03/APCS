import java.awt.*;
import javax.swing.JFrame;

public class Circles {

	boolean lifeStatus;
	int posX;
	int posY;
	
	//Parent class for Happy, Mho
	
	public Circles(boolean lifeStatus, int startPosX, int startPosY) {
		this.lifeStatus = lifeStatus;
		this.posX = startPosX*60;
		this.posY = startPosY*60;	
	}
	
	public void setLife(boolean newStatus) {
		 lifeStatus = newStatus;
	}
	
	public void changePos(int PosXDifference, int PosYDifference) {
		this.posX = posX + PosXDifference*60;
		this.posY = posY + PosYDifference*60;
	}
	
	public void setPos(int newPosX, int newPosY) {
		this.posX = newPosX*60;
		this.posY = newPosY*60;
	}
	
	public int getXPos() {
		return this.posX;
	}
	
	public int getYPos() {
		return this.posY;
	}
	

}
