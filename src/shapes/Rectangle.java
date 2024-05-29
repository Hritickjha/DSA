package shapes;

/**
 * A kind of shape that represents a rectangle.
 * 
 * @author mdixon
 */
public class Rectangle extends Shape {

	/**
	 * The width of the rectangle
	 */
	private int width;
	
	/**
	 * The height of the rectangle
	 */
	private int height;
	
	///////////////////////////////////////////////////////////////////////

	@Override
	public double getArea() {

		// TODO PART1: Calculate and return the area using width and height attributes.
		return width * height;
	}
	
	@Override
	public double getPerimeter() {
		
		// TODO PART1: Calculate and return the perimeter using width and height attributes.
		return 2 * (width + height);
	}
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		
		// TODO PART1: return the width
		return width;
		}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		
		// TODO PART1: set the width
		this.width = width;
		
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		
		// TODO PART1: return the height
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		
		// TODO PART1: set the height
		this.height = height;
	}

	/**
	 * @return true if the rectangle is actually rectangular (sides not equal length), else false.
	 */
	public boolean isRectangular() {
		
		// TODO PART1: return true if the width/height indicate the shape is a rectangle, i.e. they are different
		return width != height;
	}
	
	/**
	 * @return true if the rectangle is actually square, else false.
	 */
	public boolean isSquare() {
		
		// TODO PART1: return true if the width/height indicate the shape is a square, i.e. they are equal
		return width == height;
	}
	
	///////////////////////////////////////////////////////////////////////

	
	/**
	 * Constructor
	 * 
	 * Creates a rectangle with a width of 1 and height of 1.
	 * 
	 * @param colour the colour of the rectangle
	 */
	public Rectangle(String colour) {
		
		// TODO PART1: pass the correct number of sides, and shape name of "Rectangle" to the super() type constructor.
		// TODO PART1: also pass 'colour' as final argument instead of "RED"
		super(4, "Rectangle", colour);
		
		// TODO PART1: set the width/height attributes to the default value specified in the javadoc comment of the method.
		this.width = 1;
        this.height = 1;
	}
	
}
