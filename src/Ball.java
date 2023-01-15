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
	
	// Update the ball sprite as the game progresses
	public void update() {
		// Increase the x/y variables by xVelocity/yVelocity
		x += xVelocity;
		y += yVelocity;
		
		// Bounce off left side of screen
		if(x <= 0) {
			// Set x to 0 so it does not leave the screen
			x = 0;
			/* Change the x velocity to positive to make the ball go up the x axis.
			Rather than setting to determined integer, an equation has been used to convert into
			the opposite. This allows for the actual velocity speed to change through the game */ 
			xVelocity = xVelocity * -1;
		}
		
		// Bounce off right side of screen
		if(x >= Settings.WINDOW_WIDTH - Settings.BALL_WIDTH) {
			// Set x to the right edge of the screen so it does not leave the screen
			x = Settings.WINDOW_WIDTH - Settings.BALL_WIDTH;
			/* Change the x velocity to negative to make the ball go down the x axis.
			Rather than setting to a determined integer, an equation has been used to convert into
			the opposite. This allows for the actual velocity speed to change through the game */
			xVelocity = xVelocity * -1;
		}
		
		// Bounce off top of screen
		if(y <= 0) {
			// Set y to 0 so it does not leave the screen
			y = 0;
			/* Change the y velocity to negative the ball go down the y axis.
			Rather than setting to a determined integer, an equation has been used to convert into
			the opposite. This allows for the actual velocity speed to change through the game */
			yVelocity = yVelocity * -1;
		}
		
	}
	
	// Public method to set the velocity of x
	public void setXVelocity(int x) {
		// Set the x velocity
		xVelocity = x;
	}

	// Public method to set the velocity of y
	public void setYVelocity(int y) {
		// Set the y velocity
		yVelocity = y;
	}
	
	// Public method to get the velocity of x
	public int getXVelocity() {
		// return current int assigned to xVelocity variable
		return xVelocity;
	}

	// Public method to get the velocity of y
	public int getYVelocity() {
		// return current int assigned to xVelocity variable
		return yVelocity;
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, Settings.BALL_WIDTH, Settings.BALL_HEIGHT);
	}
}
