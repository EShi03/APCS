
public class Fence {
	private int xPosition;
	private int yPosition;
	
	public Fence(int xPosition, int yPosition){
		this.xPosition = (xPosition+1)*60;
		this.yPosition = (yPosition+1)*60;
	}
	
	public int getXPos(){
		return this.xPosition;
	}
	
	public int getYPos(){
		return this.yPosition;
	}	
}
