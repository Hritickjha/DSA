package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.ShapeMap;

/**
 * Tests the {@link ShapeMap} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART5_ShapeMapTest {

	/**
	 * The {@link ShapeMap} instance created prior to each test.
	 */
	private ShapeMap map;

	@BeforeEach
	void setUpBeforeEach() throws Exception {

		map = new ShapeMap();
	}

	@Test
	void testShapeMapCount() {

		assertEquals(0, map.shapeCount(),
				"ShapeMap should be empty when first created, ShapeMap.shapeCount() not working correctly?");
	}

	@Test
	void testShapeMapAdd() {

		Shape s1 = new Circle();

		assertEquals(1, map.addShape(new Rectangle("RED")),
				"ShapeMap.addShape() not working correctly? Not returning total shapes count");
		assertEquals(2, map.addShape(new Rectangle("BLUE")),
				"ShapeMap.addShape() not working correctly? Not returning total shapes count");

		// check 2 shapes reported
		assertEquals(2, map.shapeCount(), "ShapeMap.shapeCount() not working correctly?");

		// add a third shape
		assertEquals(3, map.addShape(new Circle("BLUE")),
				"ShapeMap.addShape() not working correctly? Not returning total shapes count");
		assertEquals(3, map.shapeCount(), "ShapeMap.shapeCount() not working correctly?");

		// add same shape twice, should not be re-added since a map (not a list).
		assertEquals(4, map.addShape(s1));
		assertEquals(4, map.addShape(s1),
				"ShapeMap.addShape() not working correctly? Adding same shape more than once?");
		assertEquals(4, map.shapeCount(), "ShapeMap.shapeCount() not working correctly?");
	}

	@Test
	void testShapeMapRemove() {

		Shape s1 = new Circle();
		Shape s2 = new Circle();

		assertEquals(1, map.addShape(s1),
				"ShapeMap.addShape() not working correctly? Not returning total shapes count");
		assertEquals(1, map.shapeCount(), "ShapeMap.shapeCount() not working correctly?");

		assertTrue(map.removeShape(s1),
				"ShapeMap.removeShape() not working correctly?, Should return true if shape removed");
		assertEquals(0, map.shapeCount(), "ShapeMap.removeShape() not working correctly? Shape not actually removed?");

		assertEquals(1, map.addShape(new Rectangle("RED")), "ShapeMap.addShape() not working correctly?");
		assertEquals(2, map.addShape(new Circle("BLUE")), "ShapeMap.addShape() not working correctly?");
		assertEquals(3, map.addShape(s1), "ShapeMap.addShape() not working correctly?");
		assertEquals(4, map.addShape(new Circle("PINK")), "ShapeMap.addShape() not working correctly?");
		assertEquals(4, map.shapeCount(), "ShapeMap.shapeCount() not working correctly?");

		// try to remove shape not yet added.
		assertFalse(map.removeShape(s2),
				"ShapeMap.removeShape() not working correctly?, Should return false if shape not present");
		assertEquals(4, map.shapeCount(), "ShapeMap.removeShape() not working correctly? Shape actually removed?");

		// now remove s1 again
		assertTrue(map.removeShape(s1),
				"ShapeMap.removeShape() not working correctly?, Should return true if shape removed");
		assertEquals(3, map.shapeCount(), "ShapeMap.removeShape() not working correctly? Shape not actually removed?");

		// try to remove s1 again, even though just removed
		assertFalse(map.removeShape(s1),
				"ShapeMap.removeShape() not working correctly?, Should return false if shape not present");
		assertEquals(3, map.shapeCount(), "ShapeMap.removeShape() not working correctly? Shape removed twice?");
	}

	@Test
	void testShapeMapContains() {

		Shape s1 = new Circle();
		Shape s2 = new Circle();

		assertFalse(map.containsShape(s1),
				"ShapeMap.containsShape() not working correctly?, Should return false if shape not present");
		assertFalse(map.containsShape(s2),
				"ShapeMap.containsShape() not working correctly?, Should return false if shape not present");

		assertEquals(1, map.addShape(s2),
				"ShapeMap.addShape() not working correctly? Not returning total shapes count");
		assertTrue(map.containsShape(s2),
				"ShapeMap.containsShape() not working correctly?, Should return true if shape present");
		assertFalse(map.containsShape(s1),
				"ShapeMap.containsShape() not working correctly?, Should return false if shape not present");
		assertEquals(1, map.shapeCount(), "ShapeMap.shapeCount() not working correctly?");

		assertEquals(2, map.addShape(s1));
		assertTrue(map.containsShape(s1),
				"ShapeMap.containsShape() not working correctly?, Should return true if shape present");
	}

	@Test
	void testShapeMapClear() {

		assertEquals(1, map.addShape(new Rectangle("RED")),
				"ShapeMap.addShape() not working correctly? Not returning total shapes count");
		assertEquals(2, map.addShape(new Rectangle("BLUE")),
				"ShapeMap.addShape() not working correctly? Not returning total shapes count");
		assertEquals(3, map.addShape(new Circle("BLUE")),
				"ShapeMap.addShape() not working correctly? Not returning total shapes count");
		assertEquals(4, map.addShape(new Rectangle("BLUE")),
				"ShapeMap.addShape() not working correctly? Not returning total shapes count");

		assertEquals(4, map.shapeCount(), "ShapeMap.shapeCount() not working correctly?");

		map.clearAllShapes();
		assertEquals(0, map.shapeCount(), "ShapeMap.clearAllShapes() not working correctly? map should be empty");
	}

	@Test
	void testShapeMapIndex() {

		// Ensure ShapeMap throws exception for unsupported operation
		assertThrows(UnsupportedOperationException.class, () -> {
			map.indexOfShape(new Rectangle("YELLOW"));
		}, "ShapeMap.indexOfShape() not working correctly? Should throw UnsupportedOperationException()");

	}

	@Test
	void testShapeMapGetLargest() {

		Rectangle r1 = new Rectangle("RED");
		r1.setHeight(10);
		r1.setWidth(100);

		Rectangle r2 = new Rectangle("PINK");
		r2.setHeight(100);
		r2.setWidth(200);

		Rectangle r3 = new Rectangle("YELLOW");
		r3.setHeight(100);
		r3.setWidth(100);

		assertNull(map.getLargestShape(), "ShapeMap.getLargestShape() should return null when the map is empty");

		assertEquals(1, map.addShape(r1), "ShapeMap.addShape() not working correctly?");
		assertEquals(2, map.addShape(r2), "ShapeMap.addShape() not working correctly?");
		assertEquals(3, map.addShape(r3), "ShapeMap.addShape() not working correctly?");

		assertSame(r2, map.getLargestShape(), "ShapeMap.getLargestShape() not working correctly?");

		Rectangle r4 = new Rectangle("BLUE");

		// add rectangle before it is set to the largest
		assertEquals(4, map.addShape(r4));

		assertSame(r2, map.getLargestShape(),
				"ShapeMap.getLargestShape() not working correctly? Not checking updated area?");

		// update r4 to be the largest shape
		r4.setHeight(1000);
		r4.setWidth(100);
		assertSame(r4, map.getLargestShape(),
				"ShapeMap.getLargestShape() not working correctly? Not checking updated area?");
	}

	@Test
	void testShapeMapGetSmallest() {

		Rectangle r1 = new Rectangle("RED");
		r1.setHeight(10);
		r1.setWidth(100);

		Rectangle r2 = new Rectangle("PINK");
		r2.setHeight(100);
		r2.setWidth(200);

		Rectangle r3 = new Rectangle("YELLOW");
		r3.setHeight(2);
		r3.setWidth(3);

		assertNull(map.getSmallestShape(), "ShapeMap.getSmallestShape() should return null when the map is empty");

		assertEquals(1, map.addShape(r1), "ShapeMap.addShape() not working correctly?");
		assertEquals(2, map.addShape(r2), "ShapeMap.addShape() not working correctly?");
		assertEquals(3, map.addShape(r3), "ShapeMap.addShape() not working correctly?");

		assertSame(r3, map.getSmallestShape(), "ShapeMap.getSmallestShape() not working correctly?");

		// update r1 to be the smallest shape
		r1.setHeight(2);
		r1.setWidth(2);
		assertSame(r1, map.getSmallestShape(),
				"ShapeMap.getSmallestShape() not working correctly? Not checking updated area?");

		// update r2 to be the smallest shape
		r2.setHeight(1);
		r2.setWidth(2);
		assertSame(r2, map.getSmallestShape(),
				"ShapeMap.getSmallestShape() not working correctly? Not checking updated area?");
	}

	@Test
	void testShapeMapCountColours() {

		assertEquals(0, map.countShapeOfColour("RED"), "ShapeMap.countShapeOfColour() not working?");

		assertEquals(1, map.addShape(new Rectangle("RED")), "ShapeMap.addShape() not working correctly?");
		assertEquals(2, map.addShape(new Rectangle("YELLOW")), "ShapeMap.addShape() not working correctly?");
		assertEquals(3, map.addShape(new Rectangle("PINK")), "ShapeMap.addShape() not working correctly?");
		assertEquals(4, map.addShape(new Rectangle("RED")), "ShapeMap.addShape() not working correctly?");
		assertEquals(2, map.countShapeOfColour("RED"), "ShapeMap.countShapeOfColour() not working?");

		assertEquals(5, map.addShape(new Rectangle("YELLOW")), "ShapeMap.addShape() not working correctly?");
		assertEquals(2, map.countShapeOfColour("RED"), "ShapeMap.countShapeOfColour() not working?");

		assertEquals(6, map.addShape(new Rectangle("RED")), "ShapeMap.addShape() not working correctly?");
		assertEquals(3, map.countShapeOfColour("RED"), "ShapeMap.countShapeOfColour() not working?");
		assertEquals(2, map.countShapeOfColour("YELLOW"), "ShapeMap.countShapeOfColour() not working?");
		assertEquals(1, map.countShapeOfColour("PINK"), "ShapeMap.countShapeOfColour() not working?");
		assertEquals(0, map.countShapeOfColour("BLUE"), "ShapeMap.countShapeOfColour() not working?");

		try {
			assertEquals(0, map.countShapeOfColour(null), "ShapeMap.countShapeOfColour() not working?");
			assertEquals(0, map.countShapeOfColour(""), "ShapeMap.countShapeOfColour() not working?");

			assertEquals(3, map.countShapeOfColour("rEd"),
					"ShapeMap.countShapeOfColour() not working with mixed case?");
			assertEquals(2, map.countShapeOfColour("yellow"),
					"ShapeMap.countShapeOfColour() not working with mixed case?");
			assertEquals(1, map.countShapeOfColour("Pink"),
					"ShapeMap.countShapeOfColour() not working with mixed case?");

			assertEquals(7, map.addShape(new Rectangle("red")), "ShapeMap.addShape() not working correctly?");
			assertEquals(4, map.countShapeOfColour("ReD"),
					"ShapeMap.countShapeOfColour() not working with mixed case?");

		} catch (Exception e) {

			fail("ShapeMap.countShapeOfColour() throwing an exception when null colour value passed, should return 0");
		}
	}

	@Test
	void testShapeMapMostCommonShape() {

		Shape s1 = new Circle();
		Shape s2 = new Circle();
		Shape s3 = new Circle();
		Shape s4 = new Circle();

		assertNull(map.getMostCommonShape(), "ShapeMap.getMostCommonShape() should return null when the map is empty");
		assertEquals(0, map.getMostCommonShapeCount(),
				"ShapeMap.getMostCommonShapeCount() should return 0 when the map is empty");

		assertEquals(1, map.addShape(s1));
		assertEquals(2, map.addShape(s2));
		assertEquals(3, map.addShape(s3));
		assertEquals(4, map.addShape(s4));

		assertEquals(4, map.addShape(s2));

		// check s2 is the most common shape (with an occurrence count of 2)
		assertSame(s2, map.getMostCommonShape(), "ShapeMap.getMostCommonShape() not working correctly?");
		assertEquals(2, map.getMostCommonShapeCount(), "ShapeMap.getMostCommonShapeCount()  not working correctly?");

		// add s1 twice more, making it the most common shape (with an occurrence count
		// of 3)
		assertEquals(4, map.addShape(s1));
		assertEquals(4, map.addShape(s1));
		assertSame(s1, map.getMostCommonShape(), "ShapeMap.getMostCommonShape() not working correctly?");
		assertEquals(3, map.getMostCommonShapeCount(), "ShapeMap.getMostCommonShapeCount()  not working correctly?");

	}
}
