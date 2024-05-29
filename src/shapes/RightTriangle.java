package shapes;

/**
 * A kind of shape that represents a right angle triangle (orthogonal triangle) in which two sides are perpendicular, and one angle is always 90 degrees.
 * 
 * The length of the third side (Hypotenuse) is not stored, since this can be calculated using Pythagoras' theorem. i.e. sideC² = (sideA² + sideB²)
 * 
 * @author mdixon
 */
public class RightTriangle extends Shape {

	/**
	 * Length of side A, always positive.
	 */
	private int sideA;

	/**
	 * Length of side B, always positive.
	 */
	private int sideB;

	///////////////////////////////////////////////////////////////////////

	@Override
	public double getArea() {

		// TODO PART3: return the area (which is half the area of a rectangle with same dimensions)
        return 0.5 * sideA * sideB;
	}

	@Override
	public double getPerimeter() {
		
		// TODO PART3: return sideA + sideB + sideC
        return sideA + sideB + getSideC();
	}
	
	/**
	 * Gets the length of side A
	 * 
	 * @return the length of side A
	 */
	public int getSideA() {

		// TODO PART3: return sideA
		return sideA;
	}
	
	/**
	 * Gets the length of side B
	 * 
	 * @return the length of side B
	 */
	public int getSideB() {

		// TODO PART3: return sideB
		return sideB;
	}
	
	/**
	 * Gets the length of the Hypotenuse (as an integer) using √(sideA² + sideB²).
	 * 
	 * @return the length of side C (the Hypotenuse) as an integer
	 */
	public int getSideC() {

		// TODO PART3: calculate return the length of sideC, 
		// hint: Read the javadoc comments and use Math.sqrt() to help (also return as an integer).
        return (int) Math.sqrt(sideA * sideA + sideB * sideB);
	}

	/**
	 * Tests if the triangle is isosceles (has two equal length sides)
	 * 
	 * @return true if the triangle is isosceles, else false.
	 */
	public boolean isIsosceles() {

		// TODO PART3: return true if two sides are of equal length
		return sideA == sideB;
	}

	/**
	 * Scales the size of the triangle by multiplying each side by the given value.
	 * 
	 * @param multiplier the value to be used to scale the sides of the triangle.
	 */
	public void expand(int multiplier) {
		
		// TODO PART3: multiply the side attributes by the given multiplier
        sideA *= multiplier;
        sideB *= multiplier;
	}
	
	/**
	 * Scales the size of the triangle by dividing each side by the given value.
	 * 
	 * @param divisor the value to be used to scale the sides of the triangle.
	 */
	public void contract(int divisor) {
		
		// TODO PART3: divide the side attributes by the given divisor
        sideA /= divisor;
        sideB /= divisor;
	}
	
	///////////////////////////////////////////////////////////////////////

	/**
	 * Constructor that creates a right angle triangle with sides equal to 3, 4 and 5.
	 * 
	 * @param colour
	 */
	public RightTriangle(String colour) {

		// TODO PART3: pass the correct number of sides, and shape name to the super() type constructor.
		
		super(3, "Triangle", colour);

		// TODO PART3: set the side attributes to the default value specified in the javadoc comment of the method.
        sideA = 3;
        sideB = 4;
	}

	/**
	 * Constructor that creates a right angle triangle with each side set to a given value.
	 * 
	 * note: Any negative values are converted to be absolute positive values.
	 *
	 * @param colour the colour of the triangle.
	 * @param a      length of side A
	 * @param b      length of side B
	 */
	public RightTriangle(String colour, int a, int b) {

		// TODO PART3: pass the correct number of sides, shape name, and colour parameter to the super() type constructor.
        super(3, "Triangle", colour);

		// TODO PART3: set the side attributes to the values given (ensuring they are not negative)
        sideA = Math.abs(a);
        sideB = Math.abs(b);
	}
}
