package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import shapes.Rectangle;

/**
 * Tests the {@link Rectangle} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART1_RectangleTest {

	@Test
	void testRectangleColour() {

		Rectangle r1 = new Rectangle("RED");
		assertTrue("RED".equals(r1.getColour()), "Rectangle (r1) colour should be set to \"RED\"");

		Rectangle r2 = new Rectangle("GREEN");
		assertTrue("GREEN".equals(r2.getColour()), "Rectangle (r2) colour should be set to \"GREEN\"");

		Rectangle r3 = new Rectangle("BLUE");
		assertTrue("BLUE".equals(r3.getColour()), "Rectangle (r3) colour should be set to \"BLUE\"");
	}

	@Test
	void testRectangleSides() {

		Rectangle r1 = new Rectangle("BLUE");
		assertEquals(4, r1.getSides(), "A Rectangle shape should have 4 sides");
	}

	@Test
	void testRectangleName() {

		Rectangle r1 = new Rectangle("BLUE");
		assertTrue("Rectangle".equals(r1.getName()), "The name of a rectangular shape should always be \"Rectangle\"");
	}

	@Test
	void testRectangleSetWidth() {

		Rectangle r1 = new Rectangle("BLUE");

		r1.setWidth(100);
		assertEquals(100, r1.getWidth(), "Rectangle.setWidth() or Rectangle.getWidth() not implemented correctly?");

		r1.setWidth(22);
		assertEquals(22, r1.getWidth(), "Rectangle.setWidth() or Rectangle.getWidth() not implemented correctly?");

		r1.setHeight(200);
		assertEquals(22, r1.getWidth(), "Rectangle.getWidth() or Rectangle.setHeight() not implemented correctly?");
	}

	@Test
	void testRectangleSetHeight() {

		Rectangle r1 = new Rectangle("BLUE");

		r1.setHeight(200);
		assertEquals(200, r1.getHeight(), "Rectangle.setHeight() or Rectangle.getHeight() not implemented correctly?");

		r1.setHeight(300);
		assertEquals(300, r1.getHeight(), "Rectangle.setHeight() or Rectangle.getHeight() not implemented correctly?");

		r1.setWidth(22);
		assertEquals(300, r1.getHeight(), "Rectangle.getHeight() or Rectangle.setWidth() not implemented correctly?");
	}

	@Test
	void testRectangleGetArea() {

		Rectangle r1 = new Rectangle("BLUE");

		r1.setHeight(5);
		r1.setWidth(10);
		assertEquals(50, r1.getArea(), "Rectangle.getArea() not implemented correctly?");

		r1.setHeight(8);
		r1.setWidth(9);
		assertEquals(72, r1.getArea(), "Rectangle.getArea() not implemented correctly?");
	}

	@Test
	void testRectangleDefaultSize() {

		Rectangle r1 = new Rectangle("BLUE");

		assertEquals(1, r1.getHeight(),
				"Constructor or Rectangle.getHeight() not implemented correctly? 'height' should be 1");
		assertEquals(1, r1.getWidth(),
				"Constructor or Rectangle.getWidth() not implemented correctly? 'width' should be 1");
		assertEquals(1, r1.getArea(), "Constructor or Rectangle.getArea() not implemented correctly?");

	}

	@Test
	void testRectangleIsSquare() {

		Rectangle r1 = new Rectangle("BLUE");

		r1.setHeight(2);
		r1.setWidth(5);
		assertFalse(r1.isSquare(), "Rectangle.isSquare() not implemented correctly?");

		r1.setHeight(3);
		r1.setWidth(3);
		assertTrue(r1.isSquare(), "Rectangle.isSquare() not implemented correctly?");
	}

	@Test
	void testRectangleIsRectangular() {

		Rectangle r1 = new Rectangle("BLUE");

		r1.setHeight(2);
		r1.setWidth(5);
		assertTrue(r1.isRectangular(), "Rectangle.isRectangular() not implemented correctly?");

		r1.setHeight(3);
		r1.setWidth(3);
		assertFalse(r1.isRectangular(), "Rectangle.isRectangular() not implemented correctly?");
	}

	@Test
	void testRectangleGetPerimeter() {

		Rectangle r1 = new Rectangle("BLUE");

		r1.setHeight(2);
		r1.setWidth(5);
		assertEquals(14, r1.getPerimeter(), "Rectangle.getPerimeter() not implemented correctly?");

		r1.setHeight(10);
		r1.setWidth(8);
		assertEquals(36, r1.getPerimeter(), "Rectangle.getPerimeter() not implemented correctly?");
	}

}
