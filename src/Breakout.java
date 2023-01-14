import java.awt.Color;

import javax.swing.JFrame;

public class Breakout extends JFrame{
	
	static final long serialVersionUID = 1L;
	
	// Private variable for the method do use as the Panel to invoke and paint inside the frame
	private BreakoutPanel panel;
	
	// Create the Frame for the game to open in
	public Breakout() {
		// Set the size of the screen (use Settings.WINDOW_WIDTH/HEIGHT)
		setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);
		// Set the title of the frame
		setTitle(Settings.WINDOW_NAME);
		// Set the background colour to white
		setBackground(Color.WHITE);
		// Stop window from being resized
		setResizable(false);
		// Ensure the program exits when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Create the gameplay panel using BreakoutPanel constructor and add to this frame
        panel = new BreakoutPanel(this);
        add(panel);
		// Set visible to true
		setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 new Breakout();	
	         }
		});

	}
}
