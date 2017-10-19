import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

class ImageComponent extends JComponent{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static Image imageFence;
    private static Image imageHappy;
    private static Image imageMho;
    String[][] grid = HivoltsRepresentitive.getGrid();
    static Mho[] mhos = new Mho[12];
    static Fence[] fences = new Fence[64];
    static Happy happy;
    boolean setUp = true;
    public ImageComponent(){
        try{
            File image2 = new File("/Users/eddie/eclipse-workspace/APCS-master/Hivolts/Fence.png");
            File image1 = new File("/Users/eddie/eclipse-workspace/APCS-master/Hivolts/Happy.png");
            File image3 = new File("/Users/eddie/eclipse-workspace/APCS-master/Hivolts/Mho.png");
            imageFence = ImageIO.read(image2);
            imageHappy = ImageIO.read(image1);
            imageMho = ImageIO.read(image3);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void paint(Graphics g) {
    		if(setUp) {
    			HivoltsRepresentitive.main();
        		int counterMho = 0;
        		int counterFence = 0;
        		for(int i = 0; i < grid.length; i++) {
        			for(int j = 0; j < grid[i].length; j++) {
        				if(grid[i][j].equals("F")){
    						Fence fence = new Fence(i,j);
    						fences[counterFence] = fence;
    						counterFence++;
    						g.drawImage(imageFence, fence.getXPos(), fence.getYPos(), this);
    					}
    					else if(grid[i][j].equals("+")){
    						happy = new Happy(true, i, j);
    						g.drawImage(imageHappy, happy.getXPos(), happy.getYPos(), this);
    					}
    					else if(!grid[i][j].equals(" ")) {
    						Mho mho = new Mho(true, i,j);
    						mhos[counterMho] = mho;
    						counterMho++;
    						g.drawImage(imageMho, mho.getXPos(), mho.getYPos(), this);
    					}
        			}
        		} 
    		}
    		else {
    			g.drawImage(imageHappy, happy.getXPos(), happy.getYPos(), this);
	    	    	for(int i = 0; i < mhos.length; i++) {
	    	    		g.drawImage(imageMho, mhos[i].getXPos(), mhos[i].getYPos(), this);
	    	    	}
    		}
    }
    
    public static Happy getHappy() {
    		return happy;
    }
    
    public static Mho[] getMhos() {
    		return mhos;
    }
    
    public static Fence[] getFences() {
    		return fences;
    }
    	
}