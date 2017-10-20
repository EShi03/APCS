
import java.awt.Graphics;

import javax.swing.JFrame;

//copied code from stackoverflow (#1) and then modified
class ImageFrame extends JFrame{
    //constuctor that sets title and size of the frame and also creates and adds an imagecomponent object and runs its repaint method to update the frame
	public ImageFrame(){
        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        ImageComponent component = new ImageComponent();
        add(component);
        component.repaint();
    }
    //defining the dimensions of the frame
    public static final int DEFAULT_WIDTH = 720;
    public static final int DEFAULT_HEIGHT = 740;
}