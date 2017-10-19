import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HivoltsFrame extends ImageFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public HivoltsFrame() {
		// makes this Class listen for key actions 
		setFocusable(true);
	    addKeyListener(this);
	}
	
	/* 
	 * Movement implementation using A, S, D, W, Q, E, Z, C, S, 
	 * and if statement for restarting the game
	*/ 
	@Override
	public void keyPressed(KeyEvent e) {
		if (ImageComponent.getHappy().lifeStatus == false) {
    			// restart the game when lost
		}
	    if (e.getKeyCode() == KeyEvent.VK_D ) {
	    		// D key code
	    		ImageComponent.getHappy().changePos(1, 0);
	    		System.out.println("PRESSED D");
	    } else if (e.getKeyCode() == KeyEvent.VK_A ) {
	        //A key code
	    		ImageComponent.getHappy().changePos(-1, 0);
	    } else if (e.getKeyCode() == KeyEvent.VK_W ) {
	        //W code
	    		ImageComponent.getHappy().changePos(0, 1);
	    } else if (e.getKeyCode() == KeyEvent.VK_X ) {
	        //X key code
	    		ImageComponent.getHappy().changePos(0, -1);
	    } else if (e.getKeyCode() == KeyEvent.VK_Q) {
	    		//Q key code
	    		ImageComponent.getHappy().changePos(-1, 1);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_E) {
	    		//E key code
	    		ImageComponent.getHappy().changePos(1, 1);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_Z) {
	    		//Z key code
	    		ImageComponent.getHappy().changePos(-1, -1);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_C) {
	    		//C key code
	    		ImageComponent.getHappy().changePos(1, -1);
	    }
	    	else if (e.getKeyCode() == KeyEvent.VK_J) {
			//J key code
	    		
	    		// Check so the player do not jump onto a fence
	    		int[][] fencesPos = new int[12][2];
	    		for(int i = 0; i < ImageComponent.getFences().length; i++) {
	    			fencesPos[i][0] = ImageComponent.getFences()[i].getXPos();
	    			fencesPos[i][1] = ImageComponent.getFences()[i].getYPos();
	    		}
	    		int position = (int)((Math.random()*(12-2))+1);
	    		position = closestNotFenceXPosition(position, fencesPos);
	    		int position2 = (int)((Math.random()*(12-2))+1);
	    		position2 = closestNotFenceYPosition(position, position2, fencesPos);
		
	    	}	
	    	else if (e.getKeyCode() == KeyEvent.VK_S) {
			//S key code
	    		// Sit on the same square
		    	System.out.println("Sit");	
		}
	    
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//helper method to determine if a row is full or isn't filled with spaces
		private static boolean isRowFull(int row, int[][] FencesPos){
			int[] arrayXPos = new int[20];
			for(int i = 0; i < FencesPos.length; i++){
				arrayXPos[i] = FencesPos[i][0];
			}
			if (getPopularElement(arrayXPos) == 10) {
				return true;
			}
			return false;
		}

		
		//finds the closest open position for columns
		private static int closestNotFenceXPosition(int row, int[][] fencesPos){
			int closestPosForward = 0;
			int closestPosBackward = 0;
			for(int j = row; j < 11; j++){
				if(!isRowFull(j, fencesPos)){
					closestPosForward = j;
					break;
				}
			}
			for(int i = row; i > 0; i--){
				if(!isRowFull(i, fencesPos)){
					closestPosBackward = i;
					break;
				}
			}
			if(closestPosForward >= closestPosBackward){
				return closestPosBackward;
			}
			return closestPosForward;
		}
		
		//finds the closest open position within a row
		private static int closestNotFenceYPosition(int position1, int position2, int[][] fencesPos){
			int closestPosForward = 1;
			int closestPosBackward = 1;
			for(int j = position2; j < 11; j++){
				if(fencesPos[position1][1] == j){
					closestPosForward = j;
					break;
				}
			}
			for(int i = position2; i > 0; i--){
				if(fencesPos[position1][1] == i){
					closestPosBackward = i;
					break;
				}
			}
			if(closestPosForward >= closestPosBackward){
				return closestPosBackward;
			}
			return closestPosForward;
		}
		
		public static int getPopularElement(int[] a)
		{
		  int count = 1, tempCount;
		  int popular = a[0];
		  int temp = 0;
		  for (int i = 0; i < (a.length - 1); i++)
		  {
		    temp = a[i];
		    tempCount = 0;
		    for (int j = 1; j < a.length; j++)
		    {
		      if (temp == a[j])
		        tempCount++;
		    }
		    if (tempCount > count)
		    {
		      popular = temp;
		      count = tempCount;
		    }
		  }
		  return count;
		}
	
}
