package testclass;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import shape.Factory;
import shape.Point;
import shape.Shape;

public class CircleTest {
    Shape circle;
    double delta = 0.1;

    /**
     * Constructor
     */
    public CircleTest() {
        circle = Factory.createShape(Shape.ShapeType.CIRCLE,  new Point(3, 4), Arrays.asList(5));
    }
    
    /**
     * Test for  getArea
     */
    @Test
    public void testGetArea() {
        assertTrue(Math.abs(78.5 - circle.getArea()) < delta);
    }

    /**
     * Test For perimeter
     */
    @Test
    public void testGetPerimeter() {
        assertTrue(Math.abs(31.4 - circle.getPerimeter()) < delta);
    }

    /**
     * Test Point Enclosed
     */
    @Test
    public void testIsPointEnclosed() {
       assertTrue(circle.isPointEnclosed(new Point(3, 4)));
       assertFalse(circle.isPointEnclosed(new Point(21, 21)));
    }
}