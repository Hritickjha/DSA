package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.ShapeList;

/**
 * Tests the {@link ShapeList} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART4_ShapeListTest {

	/**
	 * The {@link ShapeList} instance created prior to each test.
	 */
	private ShapeList list;

	@BeforeEach
	void setUpBeforeEach() throws Exception {

		list = new ShapeList();
	}

	@Test
	void testShapeListCount() {

		assertEquals(0, list.shapeCount(),
				"ShapeList should be empty when first created, ShapeList.shapeCount() not working correctly?");
	}

	@Test
	void testShapeListAdd() {

		Shape s1 = new Circle();

		assertEquals(1, list.addShape(new Rectangle("RED")),
				"ShapeList.addShape() not working correctly? Not returning total shapes count");
		assertEquals(2, list.addShape(new Rectangle("BLUE")),
				"ShapeList.addShape() not working correctly? Not returning total shapes count");

		// check 2 shapes reported
		assertEquals(2, list.shapeCount(), "ShapeList.shapeCount() not working correctly?");

		// add a third shape
		assertEquals(3, list.addShape(new Circle("BLUE")),
				"ShapeList.addShape() not working correctly? Not returning total shapes count");
		assertEquals(3, list.shapeCount(), "ShapeList.shapeCount() not working correctly?");

		// add same shape twice, should be added okay since a list (not a set).
		assertEquals(4, list.addShape(s1));
		assertEquals(5, list.addShape(s1));
		assertEquals(5, list.shapeCount(), "ShapeList.shapeCount() not working correctly?");
	}

	@Test
	void testShapeListRemove() {

		Shape s1 = new Circle();
		Shape s2 = new Circle();

		assertEquals(1, list.addShape(s1),
				"ShapeList.addShape() not working correctly? Not returning total shapes count");
		assertEquals(1, list.shapeCount(), "ShapeList.shapeCount() not working correctly?");

		assertTrue(list.removeShape(s1),
				"ShapeList.removeShape() not working correctly?, Should return true if shape removed");
		assertEquals(0, list.shapeCount(),
				"ShapeList.removeShape() not working correctly? Shape not actually removed?");

		assertEquals(1, list.addShape(new Rectangle("RED")), "ShapeList.addShape() not working correctly?");
		assertEquals(2, list.addShape(new Circle("BLUE")), "ShapeList.addShape() not working correctly?");
		assertEquals(3, list.addShape(s1), "ShapeList.addShape() not working correctly?");
		assertEquals(4, list.addShape(new Circle("PINK")), "ShapeList.addShape() not working correctly?");
		assertEquals(4, list.shapeCount(), "ShapeList.shapeCount() not working correctly?");

		// try to remove shape not yet added.
		assertFalse(list.removeShape(s2),
				"ShapeList.removeShape() not working correctly?, Should return false if shape not present");
		assertEquals(4, list.shapeCount(), "ShapeList.removeShape() not working correctly? Shape actually removed?");

		// now remove s1 again
		assertTrue(list.removeShape(s1),
				"ShapeList.removeShape() not working correctly?, Should return true if shape removed");
		assertEquals(3, list.shapeCount(),
				"ShapeList.removeShape() not working correctly? Shape not actually removed?");

		// try to remove s1 again, even though just removed
		assertFalse(list.removeShape(s1),
				"ShapeList.removeShape() not working correctly?, Should return false if shape not present");
		assertEquals(3, list.shapeCount(), "ShapeList.removeShape() not working correctly? Shape removed twice?");
	}

	@Test
	void testShapeListContains() {

		Shape s1 = new Circle();
		Shape s2 = new Circle();

		assertFalse(list.containsShape(s1),
				"ShapeList.containsShape() not working correctly?, Should return false if shape not present");
		assertFalse(list.containsShape(s2),
				"ShapeList.containsShape() not working correctly?, Should return false if shape not present");

		assertEquals(1, list.addShape(s2),
				"ShapeList.addShape() not working correctly? Not returning total shapes count");
		assertTrue(list.containsShape(s2),
				"ShapeList.containsShape() not working correctly?, Should return true if shape present");
		assertFalse(list.containsShape(s1),
				"ShapeList.containsShape() not working correctly?, Should return false if shape not present");
		assertEquals(1, list.shapeCount(), "ShapeList.shapeCount() not working correctly?");

		assertEquals(2, list.addShape(s1));
		assertTrue(list.containsShape(s1),
				"ShapeList.containsShape() not working correctly?, Should return true if shape present");
	}

	@Test
	void testShapeListClear() {

		assertEquals(1, list.addShape(new Rectangle("RED")),
				"ShapeList.addShape() not working correctly? Not returning total shapes count");
		assertEquals(2, list.addShape(new Rectangle("BLUE")),
				"ShapeList.addShape() not working correctly? Not returning total shapes count");
		assertEquals(3, list.addShape(new Circle("BLUE")),
				"ShapeList.addShape() not working correctly? Not returning total shapes count");
		assertEquals(4, list.addShape(new Rectangle("BLUE")),
				"ShapeList.addShape() not working correctly? Not returning total shapes count");

		assertEquals(4, list.shapeCount(), "ShapeList.shapeCount() not working correctly?");

		list.clearAllShapes();
		assertEquals(0, list.shapeCount(), "ShapeList.clearAllShapes() not working correctly? List should be empty");
	}

	@Test
	void testShapeListIndex() {

		Shape s1 = new Circle();
		Shape s2 = new Circle();

		try {
			assertTrue(list.indexOfShape(s1) < 0,
					"ShapeList.indexOfShape() not working correctly? Should return <0 when shape not present");
			assertTrue(list.indexOfShape(s2) < 0,
					"ShapeList.indexOfShape() not working correctly? Should return <0 when shape not present");

			assertEquals(1, list.addShape(s1),
					"ShapeList.addShape() not working correctly? Not returning total shapes count");
			assertEquals(2, list.addShape(new Rectangle("RED")),
					"ShapeList.addShape() not working correctly? Not returning total shapes count");
			assertEquals(3, list.addShape(new Rectangle("BLUE")),
					"ShapeList.addShape() not working correctly? Not returning total shapes count");
			assertEquals(4, list.addShape(new Circle("BLUE")),
					"ShapeList.addShape() not working correctly? Not returning total shapes count");

			assertEquals(0, list.indexOfShape(s1),
					"ShapeList.indexOfShape() not working correctly? Should return index when present");
			assertTrue(list.indexOfShape(s2) < 0,
					"ShapeList.indexOfShape() not working correctly? Should return <0 when shape not present");

			assertEquals(5, list.addShape(s2),
					"ShapeList.addShape() not working correctly? Not returning total shapes count");
			assertEquals(6, list.addShape(new Rectangle("BLUE")),
					"ShapeList.addShape() not working correctly? Not returning total shapes count");

			assertEquals(4, list.indexOfShape(s2),
					"ShapeList.indexOfShape() not working correctly? Should return index when present");

		} catch (UnsupportedOperationException e) {

			fail("ShapeList.indexOfShape() not working correctly? Should not throw UnsupportedOperationException() when implemented");
		}
	}

	@Test
	void testShapeListGetLargest() {

		Rectangle r1 = new Rectangle("RED");
		r1.setHeight(10);
		r1.setWidth(100);

		Rectangle r2 = new Rectangle("PINK");
		r2.setHeight(100);
		r2.setWidth(200);

		Rectangle r3 = new Rectangle("YELLOW");
		r3.setHeight(100);
		r3.setWidth(100);

		assertNull(list.getLargestShape(), "ShapeList.getLargestShape() should return null when the list is empty");

		assertEquals(1, list.addShape(r1), "ShapeList.addShape() not working correctly?");
		assertEquals(2, list.addShape(r2), "ShapeList.addShape() not working correctly?");
		assertEquals(3, list.addShape(r3), "ShapeList.addShape() not working correctly?");

		assertSame(r2, list.getLargestShape(), "ShapeList.getLargestShape() not working correctly?");

		Rectangle r4 = new Rectangle("BLUE");

		// add rectangle before it is set to the largest
		assertEquals(4, list.addShape(r4));

		assertSame(r2, list.getLargestShape(),
				"ShapeList.getLargestShape() not working correctly? Not checking updated area?");

		// update r4 to be the largest shape
		r4.setHeight(1000);
		r4.setWidth(100);
		assertSame(r4, list.getLargestShape(),
				"ShapeList.getLargestShape() not working correctly? Not checking updated area?");
	}

	@Test
	void testShapeListGetSmallest() {

		Rectangle r1 = new Rectangle("RED");
		r1.setHeight(10);
		r1.setWidth(100);

		Rectangle r2 = new Rectangle("PINK");
		r2.setHeight(100);
		r2.setWidth(200);

		Rectangle r3 = new Rectangle("YELLOW");
		r3.setHeight(2);
		r3.setWidth(3);

		assertNull(list.getSmallestShape(), "ShapeList.getSmallestShape() should return null when the list is empty");

		assertEquals(1, list.addShape(r1), "ShapeList.addShape() not working correctly?");
		assertEquals(2, list.addShape(r2), "ShapeList.addShape() not working correctly?");
		assertEquals(3, list.addShape(r3), "ShapeList.addShape() not working correctly?");

		assertSame(r3, list.getSmallestShape(), "ShapeList.getSmallestShape() not working correctly?");

		// update r1 to be the smallest shape
		r1.setHeight(2);
		r1.setWidth(2);
		assertSame(r1, list.getSmallestShape(),
				"ShapeList.getSmallestShape() not working correctly? Not checking updated area?");

		// update r2 to be the smallest shape
		r2.setHeight(1);
		r2.setWidth(2);
		assertSame(r2, list.getSmallestShape(),
				"ShapeList.getSmallestShape() not working correctly? Not checking updated area?");
	}

	@Test
	void testShapeListCountColours() {

		assertEquals(0, list.countShapeOfColour("RED"), "ShapeList.countShapeOfColour() not working?");

		assertEquals(1, list.addShape(new Rectangle("RED")), "ShapeList.addShape() not working correctly?");
		assertEquals(2, list.addShape(new Rectangle("YELLOW")), "ShapeList.addShape() not working correctly?");
		assertEquals(3, list.addShape(new Rectangle("PINK")), "ShapeList.addShape() not working correctly?");
		assertEquals(4, list.addShape(new Rectangle("RED")), "ShapeList.addShape() not working correctly?");
		assertEquals(2, list.countShapeOfColour("RED"), "ShapeList.countShapeOfColour() not working?");

		assertEquals(5, list.addShape(new Rectangle("YELLOW")), "ShapeList.addShape() not working correctly?");
		assertEquals(2, list.countShapeOfColour("RED"), "ShapeList.countShapeOfColour() not working?");

		assertEquals(6, list.addShape(new Rectangle("RED")), "ShapeList.addShape() not working correctly?");
		assertEquals(3, list.countShapeOfColour("RED"), "ShapeList.countShapeOfColour() not working?");
		assertEquals(2, list.countShapeOfColour("YELLOW"), "ShapeList.countShapeOfColour() not working?");
		assertEquals(1, list.countShapeOfColour("PINK"), "ShapeList.countShapeOfColour() not working?");
		assertEquals(0, list.countShapeOfColour("BLUE"), "ShapeList.countShapeOfColour() not working?");
	}

	@Test
	void testShapeListCountColoursAdvanced() {

		try {
			assertEquals(0, list.countShapeOfColour(null), "ShapeList.countShapeOfColour() not working?");
			assertEquals(0, list.countShapeOfColour(""), "ShapeList.countShapeOfColour() not working?");

			assertEquals(0, list.countShapeOfColour("RED"), "ShapeList.countShapeOfColour() not working?");
			assertEquals(1, list.addShape(new Rectangle("YELLOW")), "ShapeList.addShape() not working correctly?");
			assertEquals(2, list.addShape(new Rectangle("RED")), "ShapeList.addShape() not working correctly?");
			assertEquals(3, list.addShape(new Rectangle("PINK")), "ShapeList.addShape() not working correctly?");

			assertEquals(1, list.countShapeOfColour("rEd"),
					"ShapeList.countShapeOfColour() not working with mixed case?");
			assertEquals(1, list.countShapeOfColour("yellow"),
					"ShapeList.countShapeOfColour() not working with mixed case?");
			assertEquals(1, list.countShapeOfColour("Pink"),
					"ShapeList.countShapeOfColour() not working with mixed case?");

			assertEquals(4, list.addShape(new Rectangle("red")), "ShapeList.addShape() not working correctly?");
			assertEquals(2, list.countShapeOfColour("ReD"),
					"ShapeList.countShapeOfColour() not working with mixed case?");

		} catch (Exception e) {

			fail("ShapeList.countShapeOfColour() throwing an exception when null colour value passed, should return 0");
		}
	}
}
