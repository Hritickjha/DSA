package shapes;

/**
 * An abstract shape class.
 * 
 * NOTE: This file does not need changing as part of the solution. It is already fully complete.
 * 
 * @author mdixon
 */
public abstract class Shape {

	/**
	* The number of sides within the shape.
	*/
	final private int sides;
	
	/**
	 * The name of the shape.
	 */
	final private String name;

	/**
	 * The colour of the shape.
	 */
	final private String colour;
	
	///////////////////////////////////////////////////////////////////////
		
	/**
	* Gets the shape's area.
	*
	* @return the shapes area.
	*/
	abstract public double getArea();

	/**
	* Gets the shape's perimeter (i.e. total length of all sides).
	*
	* @return the shapes perimeter.
	*/
	abstract public double getPerimeter();
	
	/**
	 * @return the number of sides
	 */
	public int getSides() {
		
		return sides;
	}
	
	/**
	 * @return the name of the shape
	 */
	public String getName() {
		
		return name;
	}

	/**
	 * @return the colour of the shape
	 */
	public String getColour() {
		
		return colour;
	}

	///////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructor
	 * 
	 * @param sides the number of sides
	 * @param name the name of the shape
	 * @param colour the colour of the shape
	 */
	Shape(int sides, String name, String colour) {
		
		this.sides = sides;
		this.name = name;
		this.colour = colour;
	}
}
