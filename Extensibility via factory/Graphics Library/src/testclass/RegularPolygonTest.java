package testclass;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import shape.Factory;
import shape.Point;
import shape.Shape;

public class RegularPolygonTest {
    Shape regularPolygon;
    double delt = 0.1;
    
    
    /**Constructor*/
    public RegularPolygonTest() {
        regularPolygon = Factory.createShape(Shape.ShapeType.REGULAR_POLYGON, new Point(6, 6), Arrays.asList(6,1));
    }
    
    /**
     * Test Get Area method
     */
    @Test
    public void testGetArea() {
        assertTrue(Math.abs(2.598 - regularPolygon.getArea()) < delt);
    }
    
    /**
     * Test Perimeter method
     */
    @Test
    public void testGetPerimeter() {
        assertTrue(Math.abs(6 - regularPolygon.getPerimeter()) < delt);
    }
    
    /**
     * Test isPointEnclosed method
     */
    @Test
    public void testIsPointEnclosed() {
        assertTrue(regularPolygon.isPointEnclosed( new Point(7, 5)));
    }
}