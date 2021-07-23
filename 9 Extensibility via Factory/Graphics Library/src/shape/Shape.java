package shape;
import java.time.LocalTime;

/**
 *Interface of the shape
 */
public interface Shape {
	/**List of Shapes*/
	enum ShapeType {
		SQUARE, RECTANGLE, TRIANGLE, CIRCLE, REGULAR_POLYGON
	}
	/**Get methods*/
	double getArea();
	double getPerimeter();
	ShapeType getShapeType();
	LocalTime getTimeStamp();
	Point getOrigin();
	/** Check whether the point is enclosed with shape the object**/
	boolean isPointEnclosed(Point point);
	
}