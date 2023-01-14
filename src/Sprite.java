import java.awt.Rectangle;

public class Sprite {
	
	protected int x,y,width,height;
	
	// Note: This should only set a single value, they can be done in a single statement
	public void setX(int x) {
		// sets the protected variable x to the variable passed into the method
		this.x = x;
	}
	public void setY(int y) { 
		// sets the protected variable y to the variable passed into the method
		this.y = y;
	}
	public void setWidth(int width) { 
		// sets the protected variable width to the variable passed into the method
		this.width = width;
	}
	public void setHeight(int height) { 
		// sets the protected variable height to the variable passed into the method
		this.height = height;
	}
	
	// Note: Change the "0" to the correct variable
	public int getX() { 
		return this.x;	// Return the current set x
	}
	public int getY() { 
		return this.y;	// Return the current set y
	}
	public int getWidth() { 
		return this.width;	// Return the current set width
	}
	public int getHeight() { 
		return this.height;	// Return the current set height
	}
	
	Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}
