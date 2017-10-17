import java.awt.*;
import javax.swing.JFrame;

public class Circles {

	boolean lifeStatus;
	int posX;
	int posY;
	
	//Parent class for Happy, Mho
	
	public Circles(boolean lifeStatus, int startPosX, int startPosY) {
		this.lifeStatus = lifeStatus;
		this.posX = startPosX;
		this.posY = startPosY;	
	}
	
	public void setLife(boolean newStatus) {
		 lifeStatus = newStatus;
	}
	public void setPos(int newPosX, int newPosY) {
		posX = newPosX;
		posY = newPosY;
	}
	
	public int getXPos() {
		return this.posX;
	}
	
	public int getYPos() {
		return this.posY;
	}


	
	

}