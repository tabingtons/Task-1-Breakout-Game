import java.awt.Graphics;

public class Ball extends Sprite {

	private int xVelocity = 1, yVelocity = -1;
	
	// Constructor for the ball
	public Ball() {
		// Set width to Settings.BALL_WIDTH
		setWidth(Settings.BALL_WIDTH);
		// Set height to Settings.BALL_HEIGHT
		setHeight(Settings.BALL_HEIGHT);
		// Call the resetPosition to set ball to starting point
		resetPosition();
	}
	
	/**
	 * Resets the ball to the initial position
	 * Uses Settings.INITIAL_BALL_X/Y to set the position of the ball
	 */
	public void resetPosition() {
		setX(Settings.INITIAL_BALL_X);
		setY(Settings.INITIAL_BALL_Y);
	}
	
	public void update() {
		x += xVelocity;
		// TODO: Increase the y variable by yVelocity (see above)
		
		// Bounce off left side of screen
		if(x <= 0) {
			// TODO: Set x to 0 so it does not leave the screen
			// TODO: Change the x velocity to make the ball go right
		}
		
		// Bounce off right side of screen
		if(x >= Settings.WINDOW_WIDTH - Settings.BALL_WIDTH) {
			// TODO: Set x to the right edge of the screen (see the above if condition)
			// TODO: Change the x velocity to make the ball go left
		}
		
		// Bounce off top of screen
		if(y <= 0) {
			// TODO: Set y to 0 so it does not leave the screen
			// TODO: Change the y velocity to make the ball go downward
		}
		
	}
	
	public void setXVelocity(int x) {
		// TODO: Set the x velocity
	}
	public void setYVelocity(int y) {
		// TODO: Set the y velocity
	}
	
	public int getXVelocity() {
		return 0;	// TODO: Return the x velocity
	}
	public int getYVelocity() {
		return 0;	// TODO: Return the y velocity
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, Settings.BALL_WIDTH, Settings.BALL_HEIGHT);
	}
}
