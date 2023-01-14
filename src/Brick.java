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

	public boolean isBroken() {
		return false;	// TODO: Return the correct variable
	}
	public void setBroken(boolean b) {
		// TODO: Set the broken variable using the parameter given
	}
	
	public void paint(Graphics g) {
		if(!broken) {
			g.fillRect(x, y, Settings.BRICK_WIDTH, Settings.BRICK_HEIGHT);
		}
	}
}
