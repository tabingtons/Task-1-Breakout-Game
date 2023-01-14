import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BreakoutPanel extends JPanel implements ActionListener, KeyListener {
	
	static final long serialVersionUID = 2L;

	private boolean gameRunning = true;
	private int livesLeft = 3;
	private String screenMessage = "";
	private Ball ball;
	private Paddle paddle;
	private Brick bricks[] = new Brick[Settings.TOTAL_BRICKS];
	
	// Constructor for the BreakoutPanel
	public BreakoutPanel(Breakout game) {
		
		// Allow the KeyListener
		addKeyListener(this);
		setFocusable(true);
		
		// Create a new timer and set the delay
		Timer timer = new Timer(5, this);
		// Start the timer
		timer.start();
		
		// Create a new ball object and assign it to the ball variable
		ball = new Ball();
		// Create a new paddle object and assign it to the paddle variable
		paddle = new Paddle();
		// The bricks array was created using Settings.TOTAL_BRICKS so we can call the createBricks() method to initiate
		createBricks();

	}
	
	private void createBricks() {
		int counter = 0;
		int x_space = 0;
		int y_space = 0;
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 5; y++) {
				bricks[counter] = new Brick((x * Settings.BRICK_WIDTH) + Settings.BRICK_HORI_PADDING + x_space, (y * Settings.BRICK_HEIGHT) + Settings.BRICK_VERT_PADDING + y_space);
				counter++;
				y_space++;
			}
			x_space++;
			y_space = 0;
		}
	}
	
	private void paintBricks(Graphics g) {
		// Loop through each brick and call the paint() method
		for (int i = 0; i < Settings.TOTAL_BRICKS; i++) {
			bricks[i].paint(g);
		}
	}
	
	// Method to check the progression of the game and update as needed if the game is still running
	private void update() {
		if(gameRunning) {
			// call the methods to update the ball and paddle
			ball.update();
			paddle.update();
			// Check for collisions
			collisions();
			// Repaint the panel to show next step in gameplay
			repaint();
		}
	}
	
	private void gameOver() {
		// TODO: Set screen message
		stopGame();
	}
	
	private void gameWon() {
		// TODO: Set screen message
		stopGame();
	}
	
	private void stopGame() {
		gameRunning = false;
	}
	
	private void collisions() {
		// Check for loss
		if(ball.y > 450) {
			// Game over
			livesLeft--;
			if(livesLeft <= 0) {
				gameOver();
				return;
			} else {
				ball.resetPosition();
				ball.setYVelocity(-1);
			}
		}
		
		// Check for win
		boolean bricksLeft = false;
		for(int i = 0; i < bricks.length; i++) {
			// Check if there are any bricks left
			if(!bricks[i].isBroken()) {
				// Brick was found, close loop
				bricksLeft = true;
				break;
			}
		}
		if(!bricksLeft) {
			gameWon();
			return;
		}
		
		// Check collisions
		if(ball.getRectangle().intersects(paddle.getRectangle())) {
			// Simplified touching of paddle
			// Proper game would change angle of ball depending on where it hit the paddle
			ball.setYVelocity(-1);
		}
		
		for(int i = 0; i < bricks.length; i++) {
			if (ball.getRectangle().intersects(bricks[i].getRectangle())) {
				int ballLeft = (int) ball.getRectangle().getMinX();
	            int ballHeight = (int) ball.getRectangle().getHeight();
	            int ballWidth = (int) ball.getRectangle().getWidth();
	            int ballTop = (int) ball.getRectangle().getMinY();

	            Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
	            Point pointLeft = new Point(ballLeft - 1, ballTop);
	            Point pointTop = new Point(ballLeft, ballTop - 1);
	            Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

	            if (!bricks[i].isBroken()) {
	                if (bricks[i].getRectangle().contains(pointRight)) {
	                    ball.setXVelocity(-1);
	                } else if (bricks[i].getRectangle().contains(pointLeft)) {
	                    ball.setXVelocity(1);
	                }

	                if (bricks[i].getRectangle().contains(pointTop)) {
	                    ball.setYVelocity(1);
	                } else if (bricks[i].getRectangle().contains(pointBottom)) {
	                    ball.setYVelocity(-1);
	                }
	                bricks[i].setBroken(true);
	            }
			}
		}
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ball.paint(g);
        paddle.paint(g);
        paintBricks(g);
        
        // Draw lives left
        // TODO: Draw lives left in the top left hand corner
        
        // Draw screen message
        if(screenMessage != null) {
        	g.setFont(new Font("Arial", Font.BOLD, 18));
        	int messageWidth = g.getFontMetrics().stringWidth(screenMessage);
        	g.drawString(screenMessage, (Settings.WINDOW_WIDTH / 2) - (messageWidth / 2), Settings.MESSAGE_POSITION);
        }
    }

	@Override
	// Set the velocity of the paddle depending on whether the player is pressing left or right
	public void keyPressed(KeyEvent e) {
		// Set variable for the key that has been pressed
		int keyCode = e.getKeyCode();
		// Read if it is the left key
		if (keyCode == KeyEvent.VK_LEFT) {
			// set velocity to negative to make paddle go down the x axis
	   		paddle.setXVelocity(-1);
		}

		// Read if it is the right key
		if (keyCode == KeyEvent.VK_RIGHT) {
			// set velocity to positive to make paddle go up the x axis
			paddle.setXVelocity(1);
	 	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO: Set the velocity of the paddle after the player has released the keys
		paddle.setXVelocity(0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
	}

}
