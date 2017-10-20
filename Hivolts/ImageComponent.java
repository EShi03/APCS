import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

//copied code from stackoverflow (#1) and then modified
class ImageComponent extends JComponent implements KeyListener{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //Image variables
    private static Image imageFence;
    private static Image imageHappy;
    private static Image imageMho;
    
    //Gets the randomized board from HivoltsRepresentitive
    String[][] grid = HivoltsRepresentitive.getGrid();
    
    //create empty arrays for the created fences and mhos to go into
    static Mho[] mhos = new Mho[12];
    static Fence[] fences = new Fence[64];
    
    //create main char or happy
    static Happy happy;
    
    //boolean used to run starting run then only run the later runs
    boolean setUp = true;
    
    //constructor of image component that sets the image variables with image files
    public ImageComponent(){
    	addKeyListener(this);
        try{
            File image2 = new File("scr/Fence.png");
            File image1 = new File("scr/Happy.png");
            File image3 = new File("scr/Mho.png");
            imageFence = ImageIO.read(image2);
            imageHappy = ImageIO.read(image1);
            imageMho = ImageIO.read(image3);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    //paint method that will display things on the JFrame
    public void paint(Graphics g) {
    	
    		//starting setup
    		if(setUp) {
    			
    			//runs HivoltsRepresentitve to get a randomized board
    			HivoltsRepresentitive.main();
    			
    			//counters used to make sure that each fence/mho is placed in an array with each element next to each other
        		int counterMho = 0;
        		int counterFence = 0;
        		
        		//double nested loop with if statements for taking the representative grid and creating objects based off of it
        		for(int i = 0; i < grid.length; i++) {
        			for(int j = 0; j < grid[i].length; j++) {
        				//creates fences and stores them in a fence array, then draws the fence onto the JFrame
        				if(grid[i][j].equals("F")){
    						Fence fence = new Fence(i,j);
    						fences[counterFence] = fence;
    						counterFence++;
    						g.drawImage(imageFence, fence.getXPos(), fence.getYPos(), this);
    					}
        				//creates happy (main character) and draws it onto the JFrame
    					else if(grid[i][j].equals("+")){
    						happy = new Happy(true, i, j);
    						g.drawImage(imageHappy, happy.getXPos(), happy.getYPos(), this);
    					}
        				//creates mhos and stores them in a mho array, then draws the mho onto the JFrame
    					else if(!grid[i][j].equals(" ")) {
    						Mho mho = new Mho(true, i,j);
    						mhos[counterMho] = mho;
    						counterMho++;
    						g.drawImage(imageMho, mho.getXPos(), mho.getYPos(), this);
    					}
        			}
        		} 
        		//sets setUp to false so code doesn't run starting code again
        		setUp = false;
    		}
    		//every update after the starting setup
    		else {
    			//draws updated happy after key pressed
    			g.drawImage(imageHappy, happy.getXPos(), happy.getYPos(), this);
    			
    			//loop that moves the mhos and checks to see if they moved onto a fence, and sets their life boolean to false if it is on a fence
	    	    	for(int i = 0; i < mhos.length; i++) {
	    	    		mhos[i].mhoMove(happy);
	    	    		mhos[i].contactFence(fences);
	    	    	}
	    	    	
	    	    	//changes mhos array to array list and removes any mho that has a life boolean of false (removal of mhos doesn't work), then trims the arraylist down
	    	    	ArrayList<Mho> array = new ArrayList<Mho>(Arrays.asList(mhos));
	    	    	for(int i = 0; i < array.size(); i++) {
	    	    	 	if(!array.get(i).getLife()) {
	    	    	 		array.remove(i);
	    	    	 	}
	    	    	}
	    	    	array.trimToSize();
	    	    	
	    	    //mhos = Mho.checkLifeStatus(mhos); (unused code because arraylists worked better)
	    	    	
	    	    	//draws updated mhos
	    	    	for(int i = 0; i < array.size(); i++) {
	    	    	 	g.drawImage(imageMho, array.get(i).getXPos(), array.get(i).getYPos(), this);
	    	    	}
	    	    	//draws fences
	    	    	for(int i = 0; i < fences.length; i++) {
    	    			g.drawImage(imageFence, fences[i].getXPos(), fences[i].getYPos(), this);
    			}
    		}
    }
    
    //getter methods for happy, mho[], and fence[]
    public static Happy getHappy() {
    		return happy;
    }
    
    public static Mho[] getMhos() {
    		return mhos;
    }
    
    public static Fence[] getFences() {
    		return fences;
    }
    
    //code from stackoverflow (#2)
    //pretty sure it forces repaint or keylistener to update
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
    
    //keylistner code that adjusts the position of happy when a certain key is pressed
    //Things that didn't get finished: Happy on fence or mho and jumping
	public void keyPressed(KeyEvent e) {
		if (ImageComponent.getHappy().lifeStatus == false) {
    			// restart the game when lost
		}
	    if (e.getKeyCode() == KeyEvent.VK_D ) {
	    		// D key code
	    		ImageComponent.getHappy().changePos(1, 0);
	    		repaint();
	    } else if (e.getKeyCode() == KeyEvent.VK_A ) {
	        //A key code
	    		ImageComponent.getHappy().changePos(-1, 0);
	    		repaint();
	    } else if (e.getKeyCode() == KeyEvent.VK_W ) {
	        //W code
	    		ImageComponent.getHappy().changePos(0, -1);
	    		repaint();
	    } else if (e.getKeyCode() == KeyEvent.VK_X ) {
	        //X key code
	    		ImageComponent.getHappy().changePos(0, 1);
	    		repaint();
	    } else if (e.getKeyCode() == KeyEvent.VK_Q) {
	    		//Q key code
	    		ImageComponent.getHappy().changePos(-1, -1);
	    		repaint();
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_E) {
	    		//E key code
	    		ImageComponent.getHappy().changePos(1, -1);
	    		repaint();
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_Z) {
	    		//Z key code
	    		ImageComponent.getHappy().changePos(-1, 1);
	    		repaint();
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_C) {
	    		//C key code
	    		ImageComponent.getHappy().changePos(1, 1);
	    		repaint();
	    }
	    	else if (e.getKeyCode() == KeyEvent.VK_J) {
			//J key code
	    		
	    		// Check so the player do not jump onto a fence
	    		/*
	    		int[][] fencesPos = new int[12][2];
	    		for(int i = 0; i < ImageComponent.getFences().length; i++) {
	    			fencesPos[i][0] = ImageComponent.getFences()[i].getXPos();
	    			fencesPos[i][1] = ImageComponent.getFences()[i].getYPos();
	    		}
	    		int position = (int)((Math.random()*(12-2))+1);
	    		position = closestNotFenceXPosition(position, fencesPos);
	    		int position2 = (int)((Math.random()*(12-2))+1);
	    		position2 = closestNotFenceYPosition(position, position2, fencesPos);
	    		repaint();
	    		*/
	    	}	
	    	else if (e.getKeyCode() == KeyEvent.VK_S) {
			//S key code
	    		// Sit on the same square
		    	System.out.println("Sit");	
		    	repaint();
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
	//modified code from hivoltsRepresentitive to use for jump
	/*
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
    	*/
}