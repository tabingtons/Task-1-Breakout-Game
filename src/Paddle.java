import java.awt.Graphics;

public class Paddle extends Sprite {

	private int xVelocity;
	
	// Paddle constructor
	public Paddle() {
		// Set width to Settings.PADDLE_WIDTH
		setWidth(Settings.PADDLE_WIDTH);
		// Set height to Settings.PADDLE_HEIGHT
		setHeight(Settings.PADDLE_HEIGHT);
		// Call the resetPosition method to set paddle to starting position
		resetPosition();
	}
	
	/**
	 * Resets the paddle to the initial position
	 * Uses Settings.INITIAL_PADDLE_X/Y to set the position of the paddle
	 */
	public void resetPosition() {
		setX(Settings.INITIAL_PADDLE_X);
		setY(Settings.INITIAL_PADDLE_Y);
	}
	
	public void update() {
		x += xVelocity;
		
		// TODO: Prevent the paddle from moving outside of the screen
		// Stop at left side of screen
		if(x <= 0) {
		x -= xVelocity;
		}

		// Stop at right side of screen
		if(x >= Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH) {
			x -= xVelocity;
		}
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, Settings.PADDLE_WIDTH, Settings.PADDLE_HEIGHT);
	}
	
	public void setXVelocity(int vel) {
		// TODO: Set x velocity
		xVelocity = vel;
	}
}
