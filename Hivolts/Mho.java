import java.awt.*;
import javax.swing.JFrame;

//this is the class for the opposing character
//color is blue
public class Mho extends Circles {
	
	//super constructor from circles class
	public Mho(boolean lifeStatus, int startPosX, int startPosY) {
		super(lifeStatus, startPosX, startPosY);
	}
	
	//When mho touches wall, it dies
	public void contactFence(Fence[] fences) {
		/*
		for(int i = 0; i < fences.length; i++) {
			for(int j = 0; j < mhos.length; j++) {
				if((mhos[j].getXPos() == fences[i].getXPos()) && (mhos[j].getYPos() == fences[i].getYPos())) {
					mhos[j].setLife(false);
					System.out.println("hi");
					
				}
			}
		}
		*/
		for(int i = 0; i < fences.length; i++) {
			if((this.posX == fences[i].getXPos()) && (this.posY == fences[i].getYPos())) {
				this.lifeStatus = false;
				System.out.println("hi");
				
			}
		}
	}
	
	//unused because arraylist was better
	/*
	public static Mho[] checkLifeStatus(Mho[] mhos) {
		Mho[] retMhos = new Mho[numberOfLiveMhos(mhos)];
		int mhoCounter = 0;
		for(int i = 0; i < mhos.length; i++) {
			if(mhos[i].getLife()) {
				retMhos[mhoCounter] = mhos[i];
				mhoCounter++;
			}
		}
		return retMhos;
	}
	
	private static int numberOfLiveMhos(Mho[] mhos) {
		int retval = 0;
		for(int i = 0; i < mhos.length; i++) {
			if(mhos[i].getLife()) {
				retval++;
			}
		}
		return retval;
	}
	*/

	//when the mho the player does a move, mho takes the shortest path to happy
	public void mhoMove(Happy happy1) {
		//diag right up
		if(this.posX <  happy1.getXPos() && this.posY < happy1.getYPos()) {
			this.posX = this.posX + 60;
			this.posY = this.posY + 60;
		}
		//diag right down
		else if(this.posX > happy1.getXPos() && this.posY < happy1.getYPos()) {
			this.posX = this.posX - 60;
			this.posY = this.posY + 60;
		}
		//diag left down
		else if(this.posX <  happy1.getXPos() && this.posY > happy1.getYPos()) {
			this.posX = this.posX + 60;
			this.posY = this.posY - 60;
		}
		//diag left up
		else if(this.posX >  happy1.getXPos() && this.posY > happy1.getYPos()) {
			this.posX = this.posX - 60;
			this.posY = this.posY - 60;
		}
		//up
		else if(this.posX ==  happy1.getXPos() && this.posY < happy1.getYPos()) {
			this.posY = this.posY + 60;
		}
		//down
		else if(this.posX ==  happy1.getXPos() && this.posY > happy1.getYPos()) {
			this.posY = this.posY - 60;
		}
		//left
		else if(this.posX >  happy1.getXPos() && this.posY == happy1.getYPos()) {
			this.posX = this.posX - 60;
		}
		//right
		else if(this.posX <  happy1.getXPos() && this.posY == happy1.getYPos()) {
			this.posX = this.posX + 60;
		}
		/*
		for(int i = 0; i < mhos.length; i++) {
			//diag right up
			if((mhos[i].getXPos() < happy1.getXPos()) && (mhos[i].getYPos() < happy1.getYPos())) {
				mhos[i].changePos(60, 60);
			}
			//diag right down
			else if(mhos[i].getXPos() > happy1.getXPos() && mhos[i].getYPos() < happy1.getYPos()) {
				mhos[i].changePos(-60, 60);
			}
			//diag left down
			else if(mhos[i].getXPos() <  happy1.getXPos() && mhos[i].getYPos() > happy1.getYPos()) {
				mhos[i].changePos(60, -60);
			}
			//diag left up
			else if(mhos[i].getXPos() >  happy1.getXPos() && mhos[i].getYPos() > happy1.getYPos()) {
				mhos[i].changePos(-60, -60);
			}
			//up
			else if(mhos[i].getXPos() ==  happy1.getXPos() && mhos[i].getYPos() < happy1.getYPos()) {
				mhos[i].changePos(0, 60);
			}
			//down
			else if(mhos[i].getXPos() ==  happy1.getXPos() && mhos[i].getYPos() > happy1.getYPos()) {
				mhos[i].changePos(0, -60);
			}
			//left
			else if(mhos[i].getXPos() >  happy1.getXPos() && mhos[i].getYPos() == happy1.getYPos()) {
				mhos[i].changePos(-60, 0);
			}
			//right
			else if(mhos[i].getXPos() <  happy1.getXPos() && mhos[i].getYPos() == happy1.getYPos()) {
				mhos[i].changePos(60, 0);
			}
		}
		*/
	}
	//getter for lifestatus of a mho
	public boolean getLife() {
		return this.lifeStatus;
	}
	

}
