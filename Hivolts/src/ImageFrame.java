import javax.swing.JFrame;

class ImageFrame extends JFrame{
    public ImageFrame(){
        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        ImageComponent component = new ImageComponent();
        add(component);

    }

    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 600;
}

