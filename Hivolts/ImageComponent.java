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
    public ImageComponent(){
        try{
            File image2 = new File("Fence.png");
            File image1 = new File("Happy.png");
            File image3 = new File("Mho.png");
            imageFence = ImageIO.read(image2);
            imageHappy = ImageIO.read(image1);
            imageMho = ImageIO.read(image3);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g) {
    		HivoltsRepresentitive.main();
    		String[][] grid = HivoltsRepresentitive.getGrid();
    		for(int i = 0; i < grid.length; i++) {
    			for(int j = 0; j < grid[i].length; j++) {
    				if(grid[i][j].equals("F")){
						Fence fence = new Fence(i,j);
						g.drawImage(imageFence, fence.getXPos(), fence.getYPos(), this);
					}
					else if(grid[i][j].equals("+")){
						Happy happy = new Happy(true, i,j);
						g.drawImage(imageHappy, happy.getXPos(), happy.getYPos(), this);
					}
					else if(!grid[i][j].equals(" ")) {
						Mho mho = new Mho(true, i,j);
						g.drawImage(imageMho, mho.getXPos(), mho.getYPos(), this);
				}
    				System.out.print(grid[i][j] + " ");
    			}
    			System.out.println(" ");
    		} 
    } 
    	
}