package shapes;

/**
 * A kind of shape that represents a circle.
 * 
 * For calculations, this uses the constant {@link Math#PI} as an approximation of the value for π
 * 
 * @author mdixon
 */
public class Circle extends Shape {

	/**
	 * The radius of the circle.
	 */
	private int radius;

	///////////////////////////////////////////////////////////////////////

	@Override
	public double getArea() {
		// TODO PART2: Calculate and return the area using Area = π x r²
		// hint: Use Math.PI in the calculation
		return Math.PI * radius * radius;
	}
	
	@Override
	public double getPerimeter() {
		// TODO PART2: Calculate and return the perimeter using Perimeter = 2 x π x r
		return 2 * Math.PI * radius;
	}
		
	/**
	 * Gets the volume of the circle as if it was a spherical shape with the same radius.
	 * 
	 * @return the volume of a sphere with the same radius as the circle.
	 */
	public double getVolume() {
		// TODO PART2: Calculate and return the volume using Volume = 4/3 x π x r³
		return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
	}
	
	/**
	 * @return the radius
	 */
	public int getRadius() {
		// TODO PART2: Return the radius
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		// TODO PART2: Set the radius
		this.radius = radius;
	}
	
	/**
	 * Tests if the circle has a radius larger than the one provided.
	 * 
	 * @param radius the radius to compare against the circle's radius
	 * @return true if the circle has a radius that is greater than the given radius, else false.
	 */
	public boolean isLargerThan(int radius) {
		// TODO PART2: Return true if the circle's radius is larger than the one given
		return this.radius > radius;
	}
	
	/**
	 * Tests if the circle has a radius smaller than the one provided.
	 * 
	 * @param radius the radius to compare against the circle's radius
	 * @return true if the circle has a radius that is less than the given radius, else false.
	 */
	public boolean isSmallerThan(int radius) {
		// TODO PART2: Return true if the circle's radius is smaller than the one given
		return this.radius < radius;
	}
	
	///////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructor
	 * 
	 * @param colour the colour of the circle
	 * @param radius the radius of the circle
	 */
	public Circle(String colour, int radius) {
		// TODO PART2: Pass the correct number of sides, and shape name to the super() type constructor.
		super(0, "Circle", colour);
		// TODO PART2: Set the radius attribute to the given value
		this.radius = radius;
	}

	/**
	 * Constructor
	 * 
	 * Creates a circle with a default radius of 10.
	 *  
	 * @param colour the colour of the circle
	 */
	public Circle(String colour) {
		// TODO PART2: Pass the correct number of sides, and shape name to the super() type constructor.
		super(0, "Circle", colour);
		// TODO PART2: Set the radius attribute to the default value specified in the javadoc comment of the method.
		this.radius = 10;
	}
	
	/**
	 * Default Constructor
	 * 
	 * Creates a "RED" circle with a default radius of 1.  
	 */
	public Circle() {
		// TODO PART2: Pass the correct number of sides, shape name and default colour (see comment) to the super() type constructor.
		super(0, "Circle", "RED");
		// TODO PART2: Set the radius attribute to the default value specified in the javadoc comment of the method.
		this.radius = 1;
	}
}
