package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import shapes.RightTriangle;

/**
 * Tests the {@link RightTriangle} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART3_TriangleTest {

	@Test
	void testTriangleColour() {

		RightTriangle t1 = new RightTriangle("YELLOW");
		assertTrue("YELLOW".equals(t1.getColour()), "Triangle (t1) colour should be set to \"YELLOW\"");

		RightTriangle t2 = new RightTriangle("MAUVE");
		assertTrue("MAUVE".equals(t2.getColour()), "Triangle (t2) colour should be set to \"MAUVE\"");

		RightTriangle t3 = new RightTriangle("BLUE", 10, 20);
		assertTrue("BLUE".equals(t3.getColour()),
				"Triangle (t3) colour should be set to \"BLUE\", RightTriangle(String colour, int a, int b) constructor not working?");
	}

	@Test
	void testTriangleSides() {

		RightTriangle t1 = new RightTriangle("BLUE");
		assertEquals(3, t1.getSides(), "A Triangular shape should have 3 sides");

		RightTriangle t2 = new RightTriangle("BLUE", 2, 20);
		assertEquals(3, t2.getSides(), "A Triangular shape should have 3 sides");
	}

	@Test
	void testTriangleName() {

		RightTriangle t1 = new RightTriangle("BLUE");
		assertTrue("Triangle".equals(t1.getName()), "The name of a triangular shape should always be \"Triangle\"");

		RightTriangle t2 = new RightTriangle("PINK", 20, 10);
		assertTrue("Triangle".equals(t2.getName()),
				"The name of a triangular shape should always be \"Triangle\", RightTriangle(String colour, int a, int b) constructor not working?");
	}

	@Test
	void testTriangleConstructor() {

		RightTriangle t1 = new RightTriangle("BLUE", 30, 40);
		assertEquals(30, t1.getSideA(),
				"RightTriangle(String colour, int a, int b) constructor not working? Not setting 'sideA' correctly?");
		assertEquals(40, t1.getSideB(),
				"RightTriangle(String colour, int a, int b) constructor not working? Not setting 'sideB' correctly?");

		RightTriangle t2 = new RightTriangle("RED", 60, 50);
		assertEquals(60, t2.getSideA(),
				"RightTriangle(String colour, int a, int b) constructor not working? Not setting 'sideA' correctly?");
		assertEquals(50, t2.getSideB(),
				"RightTriangle(String colour, int a, int b) constructor not working? Not setting 'sideB' correctly?");

		RightTriangle t3 = new RightTriangle("PINK", -20, -10);
		assertEquals(20, t3.getSideA(),
				"RightTriangle(String colour, int a, int b) constructor not working? Not detecting negative 'a' value");
		assertEquals(10, t3.getSideB(),
				"RightTriangle(String colour, int a, int b) constructor not working? Not detecting negative 'b' value");
	}

	@Test
	void testTriangleDefaultConstructor() {

		RightTriangle t1 = new RightTriangle("BLUE");
		assertEquals(3, t1.getSideA(),
				"RightTriangle(String colour) constructor not working? Not setting 'sideA' correctly?");
		assertEquals(4, t1.getSideB(),
				"RightTriangle(String colour) constructor not working? Not setting 'sideB' correctly?");
	}

	@Test
	void testTriangleGetArea() {

		RightTriangle t1 = new RightTriangle("BLUE");
		assertEquals(6, t1.getArea(), "RightTriangle.getArea() not working?");

		RightTriangle t2 = new RightTriangle("RED", 40, 50);
		assertEquals(1000, t2.getArea(), "RightTriangle.getArea() not working?");
	}

	@Test
	void testTriangleGetPerimitimer() {

		RightTriangle t1 = new RightTriangle("BLUE");
		assertEquals(12, t1.getPerimeter(), "RightTriangle.getPerimeter() not working?");

		RightTriangle t2 = new RightTriangle("RED", 40, 30);
		assertEquals(120, t2.getPerimeter(), "RightTriangle.getPerimeter() not working?");
	}

	@Test
	void testTriangleGetSideC() {

		RightTriangle t1 = new RightTriangle("BLUE");
		assertEquals(5, t1.getSideC(), "RightTriangle.getSideC() not working?");

		RightTriangle t2 = new RightTriangle("RED", 100, 100);
		assertEquals(141, t2.getSideC(), "RightTriangle.getSideC() not working? Not truncating to integer?");
	}

	@Test
	void testTriangleExpand() {

		RightTriangle t1 = new RightTriangle("BLUE");
		t1.expand(10);
		assertEquals(30, t1.getSideA(), "RightTriangle.expand() not working? Not scaling sideA?");
		assertEquals(40, t1.getSideB(), "RightTriangle.expand() not working? Not scaling sideB?");
		assertEquals(50, t1.getSideC(),
				"RightTriangle.expand() or RightTriangle.getSideC() not working? Not scaling sideC?");

		RightTriangle t2 = new RightTriangle("BLUE", 100, 50);
		t2.expand(2);
		assertEquals(200, t2.getSideA(), "RightTriangle.expand() not working? Not scaling sideA?");
		assertEquals(100, t2.getSideB(), "RightTriangle.expand() not working? Not scaling sideB?");
		assertEquals(223, t2.getSideC(),
				"RightTriangle.expand() or RightTriangle.getSideC() not working? Not scaling sideC?");
	}

	@Test
	void testTriangleContract() {

		RightTriangle t1 = new RightTriangle("YELLOW", 8, 6);
		t1.contract(2);
		assertEquals(4, t1.getSideA(), "RightTriangle.contract() not working? Not scaling sideA?");
		assertEquals(3, t1.getSideB(), "RightTriangle.contract() not working? Not scaling sideB?");
		assertEquals(5, t1.getSideC(),
				"RightTriangle.contract() RightTriangle.getSideC() not working? Not scaling sideC?");
	}

}
