package testclass;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import shape.*;

public class ScreenTest {
    Screen screen;
    Shape circle;
    Shape square;
    Shape rectangle;
    Shape triangle;
    Shape regularPolygon;
    
    /**Constructor*/
    public ScreenTest() {
 
        circle = Factory.createShape(Shape.ShapeType.CIRCLE,  new Point(3, 4), Arrays.asList(5));   
        square = Factory.createShape(Shape.ShapeType.SQUARE, new Point(4, 4),  Arrays.asList(6));   
        rectangle = Factory.createShape(Shape.ShapeType.RECTANGLE,  new Point(5, 5),  Arrays.asList(6,3));   
        triangle = Factory.createShape(Shape.ShapeType.TRIANGLE, new Point(6, 6), Arrays.asList(3,4,5));
        regularPolygon = Factory.createShape(Shape.ShapeType.REGULAR_POLYGON, new Point(7, 7), Arrays.asList(6,1));
        
        screen = new Screen();
        screen.addShape(triangle);
        screen.addShape(regularPolygon);
        screen.addShape(circle);
        screen.addShape(square);
        screen.addShape(rectangle);
    }

    /**
     * Sort by area test
     */
    @Test
    public void testGetShapesSortedByArea() {
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(regularPolygon);
        expectedOutput.add(triangle);
        expectedOutput.add(rectangle);
        expectedOutput.add(square);
        expectedOutput.add(circle);
        List<Shape> actualOutput = screen.sortShape(SortType.AREA);   
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Sort By Perimeter test
     */
    @Test
    public void testGetShapesSortedByPerimeter() {
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(regularPolygon);
        expectedOutput.add(triangle);
        expectedOutput.add(rectangle);
        expectedOutput.add(square);
        expectedOutput.add(circle);
        List<Shape> actualOutput = screen.sortShape(SortType.PERIMETER);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Sort by Timestamp test
     */
    @Test
    public void testGetShapesSortedByTimestamp() {
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(circle);
        expectedOutput.add(square);
        expectedOutput.add(rectangle);
        expectedOutput.add(triangle);
        expectedOutput.add(regularPolygon);
        List<Shape> actualOutput = screen.sortShape(SortType.TIMESTAMP);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Sort by origin distance test
     */
    @Test
    public void testGetShapesSortedByOriginDistance() {
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(circle);
        expectedOutput.add(square);
        expectedOutput.add(rectangle);
        expectedOutput.add(triangle);
        expectedOutput.add(regularPolygon);
        List<Shape> actualOutput = screen.sortShape(SortType.ORIGIN_DISTANCE);
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Get Enclosing Shape test
     */
    @Test
    public void testGetEnclosingShapes() {
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(circle);
        expectedOutput.add(square);
        assertEquals(expectedOutput, screen.getEnclosingShapes(new Point(5, 5)));
    }

}