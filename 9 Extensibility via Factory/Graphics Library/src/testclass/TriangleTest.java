package testclass;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

import shape.Factory;
import shape.Point;
import shape.Shape;

/**
 * Triangle class with parent class as Shape
 */
public class TriangleTest {
    Shape triangle;
    double delta = 0.1;

    /**
     * Constructor
     */
    public TriangleTest() {
        triangle = Factory.createShape(Shape.ShapeType.TRIANGLE,  new Point(6, 6), Arrays.asList(3,4,5));
    }

    /**
     * Test Get Area
     */
    @Test
    public void testGetArea() {
        assertTrue(Math.abs(6 - triangle.getArea()) < delta);
    }
    
    /**
     * Test Get Preimeter
     */
    @Test
    public void testGetPerimeter() {
        assertTrue(Math.abs(12 - triangle.getPerimeter()) < delta);
    }

    /**
     * Test point enclosed
     */
    @Test
    public void testIsPointEnclosed() {
        assertFalse(triangle.isPointEnclosed(new Point(7, 5)));
    }

}