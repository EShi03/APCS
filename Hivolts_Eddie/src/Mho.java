import java.awt.*;
import javax.swing.JFrame;

//this is the class for the opposing character
//color is blue
public class Mho extends Circles {

	public Mho(boolean lifeStatus, int startPosX, int startPosY) {
		super(lifeStatus, startPosX, startPosY);
	}
	
	//When mho touches wall, it dies
	public void contactFence(Fence fence) {
		if(this.posX == fence.getXPos() && this.posY == fence.getYPos()) {
			this.lifeStatus = false;
		}
	}
	//when the mho the player does a move, mho
	public void mhoMove(Happy happy) {
		if(this.posX <  happy.posX && this.posY < happy.posY) {
			
		}
		else if(this.posX) {
			
		}
		else if(this.posX) {
			
		}
		else()
	}
	

}