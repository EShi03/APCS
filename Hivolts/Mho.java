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
			this.posX = this.posX + 1;
			this.posY = this.posY - 1;
		}
		//diag right down
		else if(this.posX > happy1.getXPos() && this.posY < happy1.getYPos()) {
			this.posX = this.posX + 1;
			this.posY = this.posY + 1;
		}
		//diag left down
		else if(this.posX <  happy1.getXPos() && this.posY > happy1.getYPos()) {
			this.posX = this.posX - 1;
			this.posY = this.posY + 1;
		}
		//diag left up
		else if(this.posX <  happy1.getXPos() && this.posY < happy1.getYPos()) {
			this.posX = this.posX - 1;
			this.posY = this.posY - 1;
		}
		//up
		else if(this.posX ==  happy1.getXPos() && this.posY < happy1.getYPos()) {
			this.posY = this.posY - 1;
		}
		//down
		else if(this.posX ==  happy1.getXPos() && this.posY > happy1.getYPos()) {
			this.posY = this.posY + 1;
		}
		//left
		else if(this.posX >  happy1.getXPos() && this.posY == happy1.getYPos()) {
			this.posX = this.posX - 1;
		}
		//right
		else if(this.posX <  happy1.getXPos() && this.posY == happy1.getYPos()) {
			this.posX = this.posX + 1;
		}
	}
	

}
