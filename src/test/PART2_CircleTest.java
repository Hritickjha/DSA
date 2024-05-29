package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import shapes.Circle;

/**
 * Tests the {@link Circle} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART2_CircleTest {

	@Test
	void testCircleColour() {

		Circle c1 = new Circle("PINK");
		assertTrue("PINK".equals(c1.getColour()), "Circle (c1) colour should be set to \"PINK\"");

		Circle c2 = new Circle();
		assertTrue("RED".equals(c2.getColour()),
				"Circle (c2) colour should be set to \"RED\", Circle() default constructor not working?");

		Circle c3 = new Circle("BLUE", 10);
		assertTrue("BLUE".equals(c3.getColour()),
				"Circle (c3) colour should be set to \"BLUE\", Circle(String colour, int radius) constructor not working?");
	}

	@Test
	void testCircleSides() {

		Circle c1 = new Circle("BLUE");
		assertEquals(1, c1.getSides(), "A Circlular shape should have 1 side");

		Circle c2 = new Circle("BLUE", 2);
		assertEquals(1, c2.getSides(), "A Circlular shape should have 1 side");

		Circle c3 = new Circle();
		assertEquals(1, c3.getSides(), "A Circlular shape should have 1 side");
	}

	@Test
	void testCircleName() {

		Circle c1 = new Circle("BLUE");
		assertTrue("Circle".equals(c1.getName()), "The name of a circular shape should always be \"Circle\"");

		Circle c2 = new Circle("PINK", 20);
		assertTrue("Circle".equals(c2.getName()),
				"The name of a circular shape should always be \"Circle\", Circle(String colour, int radius) constructor not working?");

		Circle c3 = new Circle();
		assertTrue("Circle".equals(c3.getName()),
				"The name of a circular shape should always be \"Circle\" , Circle() default constructor not working?");
	}

	@Test
	void testCircleSetRadius() {

		Circle c1 = new Circle("BLUE");

		assertEquals(10, c1.getRadius(),
				"Circle(String colour) constructor implemented correctly? Default 'radius' should be 10");

		Circle c2 = new Circle();
		assertEquals(1, c2.getRadius(),
				"Circle() default constructor not implemented correctly? Default 'radius' should be 1");

	}

	@Test
	void testCircleDefaultRadius() {

		Circle c1 = new Circle("BLUE");

		c1.setRadius(99);
		assertEquals(99, c1.getRadius(), "Circle.setRadius() or Circle.getRadius() not implemented correctly?");

		c1.setRadius(101);
		assertEquals(101, c1.getRadius(), "Circle.setRadius() or Circle.getRadius() not implemented correctly?");
	}

	@Test
	void testCircleGetArea() {

		Circle c1 = new Circle("RED");

		c1.setRadius(10);
		assertEquals(100 * Math.PI, c1.getArea(), "Circle.getArea() not implemented correctly?");

		c1.setRadius(5);
		assertEquals(25 * Math.PI, c1.getArea(), "Circle.getArea() not implemented correctly?");
	}

	@Test
	void testCircleGetPerimeter() {

		Circle c1 = new Circle("RED");

		c1.setRadius(10);
		assertEquals(2 * Math.PI * 10, c1.getPerimeter(), "Circle.getPerimeter() not implemented correctly?");

		c1.setRadius(11);
		assertEquals(2 * Math.PI * 11, c1.getPerimeter(), "Circle.getPerimeter() not implemented correctly?");
	}

	@Test
	void testCircleIsLargerThan() {

		Circle c1 = new Circle("RED");

		c1.setRadius(10);
		assertTrue(c1.isLargerThan(9), "Circle.isLargerThan() not implemented correctly?");
		assertTrue(c1.isLargerThan(1), "Circle.isLargerThan() not implemented correctly?");
		assertFalse(c1.isLargerThan(10), "Circle.isLargerThan() not implemented correctly?");
		assertFalse(c1.isLargerThan(11), "Circle.isLargerThan() not implemented correctly?");
		assertFalse(c1.isLargerThan(100), "Circle.isLargerThan() not implemented correctly?");
	}

	@Test
	void testCircleIsSmallerThan() {

		Circle c1 = new Circle("RED");

		c1.setRadius(100);
		assertTrue(c1.isSmallerThan(101), "Circle.isSmallerThan() not implemented correctly?");
		assertTrue(c1.isSmallerThan(102), "Circle.isSmallerThan() not implemented correctly?");
		assertFalse(c1.isSmallerThan(100), "Circle.isSmallerThan() not implemented correctly?");
		assertFalse(c1.isSmallerThan(99), "Circle.isSmallerThan() not implemented correctly?");
		assertFalse(c1.isSmallerThan(1), "Circle.isSmallerThan() not implemented correctly?");
	}

	@Test
	void testCircleGetVolume() {

		Circle c1 = new Circle("RED");

		c1.setRadius(10);
		assertEquals((4 / 3.0) * Math.PI * 1000, c1.getVolume(), "Circle.getVolume() not implemented correctly?");

		c1.setRadius(5);
		assertEquals((4 / 3.0) * Math.PI * 125, c1.getVolume(), "Circle.getVolume() not implemented correctly?");
	}
}
