/* Rect.java- representation of a rectangle object*/
public class Rect {
	/* Location of the top left corner of the rectangle */
	private int x;
	private int y;
	
	/* The dimensions of the rectangle */
	private int width;
	private int height;
	
	/* Constructor - constructs the rectangle
	 * @param int w sets the width
	 * @param int h sets the height */
	public Rect(int w, int h) {
		width = w;
		height = h;
	}
	
	/* Retrieves the value of the x coordinate 
	 * @return x coordinate of the top left corner of the rectangle*/
	public int getX() {
		return x;
	}
	
	/* Retrieves the value of the y coordinate 
	 * @return y coordinate of the top left corner of the rectangle*/
	public int getY() {
		return y;
	}
	
	/* Retrieves the width of the rectangle
	 * @return rectangle's width*/
	public int getWidth() {
		return width;
	}
	
	/* Retrieves the height of the rectangle
	 * @return rectangle's height*/
	public int getHeight() {
		return height;
	}
	
	/*Shifts the location of the upper left corner of the rectangle by adding dx & dy
	 * @param dx amount to move this corner in x direction
	 * @param dy amount to move this corner in y direction*/
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
}
