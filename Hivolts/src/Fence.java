
public class Fence {
	private int xPosition;
	private int yPosition;
	
	public Fence(int xPosition, int yPosition){
		this.xPosition = (xPosition+1)*50;
		this.yPosition = (yPosition+1)*50;
	}
	
	public int getXPosition(){
		return this.xPosition;
	}
	
	public int getYPosition(){
		return this.yPosition;
	}	
}
