import java.awt.Graphics;

public class Brick extends Sprite {
	
	private boolean broken = false;
	
	public Brick(int x, int y) {
		// Set x using the parameter
		setX(x);
		// Set y using the parameter
		setY(y);
		// Set the width and height of the brick using Settings.BRICK_WIDTH/HEIGHT
		setWidth(Settings.BRICK_WIDTH);
		setHeight(Settings.BRICK_HEIGHT);
	}

	// Method to check if the brick is broken
	public boolean isBroken() {
		// return broken boolean variable for this brick
		return broken;
	}

	// Set the broken boolean variable according to the variable passed to the method
	public void setBroken(boolean b) {
		// Set the broken variable using the parameter given
		broken = b;
	}
	
	public void paint(Graphics g) {
		if(!broken) {
			g.fillRect(x, y, Settings.BRICK_WIDTH, Settings.BRICK_HEIGHT);
		}
	}
}
