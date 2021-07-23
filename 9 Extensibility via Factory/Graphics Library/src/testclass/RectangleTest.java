package testclass;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import shape.Factory;
import shape.Point;
import shape.Shape;

public class RectangleTest {
    Shape rectangle;
    double delta = 0.1;
    
    /**Constructor */
    public RectangleTest() {
        rectangle = Factory.createShape(Shape.ShapeType.RECTANGLE,  new Point(4, 4), Arrays.asList(6,3));
    }
    
    /*** Test get Area method ***/
    @Test
    public void testGetArea() {
        assertTrue(Math.abs(18 - rectangle.getArea()) < delta);
    }
    
    /*** Test Get Perimeter Method ***/
    @Test
    public void testGetPerimeter() {
        assertTrue(Math.abs(18 - rectangle.getPerimeter()) < delta);;
    }
    
    /*** Test isPointEnclose ***/
    @Test
    public void testIsPointEnclosed() {
      assertTrue(rectangle.isPointEnclosed(new Point(5, 6)));
      assertFalse(rectangle.isPointEnclosed(new Point(2, 6)));
    }

}