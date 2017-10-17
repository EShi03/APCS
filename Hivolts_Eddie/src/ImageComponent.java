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
    String[][] grid = new String[12][12];
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
    
    public static Image getFence() {
    		return imageFence;
    }
    
    public Image getHappy() {
		return imageHappy;
    }

	public Image getMho() {
		return imageMho;
	}
    
}