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
			
		}
	}
	//when the mho the player does a move, mho
	public void mhoMove(Happy happy1) {
		//diag right up
		if(this.posX <  happy1.getXPos() && this.posY < happy1.getYPos()) {
			
		}
		//diag right down
		else if(this.posX > happy1.getXPos() && this.posY < happy1.getYPos()) {
			
		}
		//diag left down
		else if(this.posX <  happy1.getXPos() && this.posY > happy1.getYPos()) {
			
		}
		//diag left up
		else if(this.posX <  happy1.getXPos() && this.posY < happy1.getYPos()) {
			
		}
		//up
		else if(this.posX ==  happy1.getXPos() && this.posY < happy1.getYPos()) {
			
		}
		//down
		else if(this.posX ==  happy1.getXPos() && this.posY > happy1.getYPos()) {
			
		}
		//left
		else if(this.posX >  happy1.getXPos() && this.posY == happy1.getYPos()) {
			
		}
		//right
		else if(this.posX <  happy1.getXPos() && this.posY == happy1.getYPos()) {
			
		}
	}
	

}
