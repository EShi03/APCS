import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HivoltsFrame extends Main implements KeyListener{

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
		if (happy.lifeStatus == false && e.getKeyCode()) {
    			// restart the game when lost
			stop();
			start();
		}
	    if (e.getKeyCode() == KeyEvent.VK_D ) {
	    		// D key code
	    		posX += 1;
	    		System.out.println("PRESSED D");
	    } else if (e.getKeyCode() == KeyEvent.VK_A ) {
	        //A key code
	    		posX -= 1;
	    } else if (e.getKeyCode() == KeyEvent.VK_W ) {
	        //W code
	    		posY -= 1;
	    } else if (e.getKeyCode() == KeyEvent.VK_S ) {
	        //S key code
	    		posY += 1;
	    } else if (e.getKeyCode() == KeyEvent.VK_Q) {
	    		//Q key code
	    		posX -= 1;
	    		posY -= 1;
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_E) {
	    		//E key code
	    		posX += 1;
	    		posY -= 1;
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_Z) {
	    		//Z key code
	    		posX -= 1;
	    		posY += 1;
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_C) {
	    		//C key code
	    		posX -= 1;
	    		posY += 1;
	    }
	    	else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			//SPACE key code
	    		posX = (int)((Math.random()*9.0)+1);
			posY = (int)((Math.random()*9.0)+1);
		
	    	}	
	    	else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
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
	
}