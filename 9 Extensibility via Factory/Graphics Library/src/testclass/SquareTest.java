package testclass;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import shape.Factory;
import shape.Point;
import shape.Shape;

public class SquareTest {
    Shape square;
    double delta = 0.1;

    public SquareTest() {
        square = Factory.createShape(Shape.ShapeType.SQUARE,  new Point(4, 4), Arrays.asList(6));
    }
    
    /**
     * Test get area method
     */
    @Test
    public void testGetArea() {
        assertTrue(Math.abs(36 - square.getArea()) < delta);
    }

    /**
     * Test Get Perimeter
     */
    @Test
    public void testGetPerimeter() {
        assertTrue(Math.abs(24 - square.getPerimeter()) < delta);
    }

    /**
     * Test Point is Enclosed
     */
    @Test
    public void testIsPointEnclosed() {
       assertTrue(square.isPointEnclosed(new Point(5, 6)));
       assertFalse(square.isPointEnclosed(new Point(2, 6)));
    }
}