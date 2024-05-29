package shapes;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements the {@link ShapeCollection} interface using an underlying map allowing the number of occurrences of each added shape to be counted.
 *
 * If the same shape is added more than once, then it is not re-added, but its occurrence count is increased.
 * 
 * @author mdixon
 */
public class ShapeMap implements ShapeCollection {

    /**
     * A collection which maps contained shapes to an occurrence count.
     */
    private Map<Shape, Integer> shapes;

    public ShapeMap() {
        // TODO PART5: Initialize the shapes map in the constructor
        shapes = new HashMap<>();
    }

    @Override
    public int addShape(Shape shape) {
        // TODO PART5: Implement the logic to add the shape to the map
        shapes.put(shape, shapes.getOrDefault(shape, 0) + 1);
        return shapes.size();
    }

    @Override
    public boolean removeShape(Shape shape) {
        // TODO PART5: Implement the logic to remove the shape from the map
        if (shapes.containsKey(shape)) {
            int count = shapes.get(shape);
            if (count == 1) {
                shapes.remove(shape);
            } else {
                shapes.put(shape, count - 1);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsShape(Shape shape) {
        // TODO PART5: Implement the logic to check if the map contains the given shape
        return shapes.containsKey(shape);
    }

    @Override
    public int shapeCount() {
        // TODO PART5: Implement the logic to return the number of key/value pairs in the map
        return shapes.size();
    }

    @Override
    public void clearAllShapes() {
        // TODO PART5: Implement the logic to remove all shapes from the map
        shapes.clear();
    }

    @Override
    public int indexOfShape(Shape shape) {
        // TODO PART5: Implement the logic to throw UnsupportedOperationException
        throw new UnsupportedOperationException("indexOfShape operation is not supported");
    }

    @Override
    public Shape getLargestShape() {
        // TODO PART5: Implement the logic to iterate the map and find the shape with the largest area
        // You can use a loop to iterate through the shapes and compare their areas
        // Return the shape with the largest area
        return null;
    }

    @Override
    public Shape getSmallestShape() {
        // TODO PART5: Implement the logic to iterate the map and find the shape with the smallest area
        // You can use a loop to iterate through the shapes and compare their areas
        // Return the shape with the smallest area
        return null;
    }

    @Override
    public int countShapeOfColour(String colour) {
        // TODO PART5: Implement the logic to iterate the map and count the shapes with the given colour
        int count = 0;
        for (Shape shape : shapes.keySet()) {
            if (shape.getColour().equalsIgnoreCase(colour)) {
                count += shapes.get(shape);
            }
        }
        return count;
    }

    /**
     * Gets the shape which has the highest occurrence count.
     *
     * @return the shape which has been added to the collection the most number of times, null if no shapes exist within the collection.
     */
    public Shape getMostCommonShape() {
        // TODO PART5: Implement the logic to find the shape with the highest occurrence count
        Shape mostCommonShape = null;
        int maxOccurrences = 0;

        for (Map.Entry<Shape, Integer> entry : shapes.entrySet()) {
            if (entry.getValue() > maxOccurrences) {
                mostCommonShape = entry.getKey();
                maxOccurrences = entry.getValue();
            }
        }

        return mostCommonShape;
    }

    /**
     * Gets the occurrence count of the most common shape.
     *
     * @return the occurrence count of the most common shape, 0 if no shapes exist within the collection.
     */
    public int getMostCommonShapeCount() {
        // TODO PART5: Implement the logic to get the occurrence count of the most common shape
        Shape mostCommonShape = getMostCommonShape();
        return mostCommonShape != null ? shapes.get(mostCommonShape) : 0;
    }
}
