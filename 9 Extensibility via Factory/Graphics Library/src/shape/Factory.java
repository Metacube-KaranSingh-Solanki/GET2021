package shape;
import java.util.List;
/**
 * Only contains method for creating the shapes.
 */
public class Factory {
	/**
	 * Method to create the shape on the screen
	 * @param shapeType    define type of shape we want to create
	 * @param point        point of the origin of the shape
	 * @param measurements other parameters require to create a shape
	 * @return shape object
	 */
	public static Shape createShape(Shape.ShapeType shapeType, Point point, List<Integer> measurements) {
		Shape shape = null;
		switch (shapeType) {
		case SQUARE:
			shape = new Square(point, measurements);
			break;
		case RECTANGLE:
			shape = new Rectangle(point, measurements); // Length, Width or vice versa
			break;
		case CIRCLE:
			shape= new Circle(point, measurements);
			break;
		case REGULAR_POLYGON:
			shape= new RegularPolygon(point, measurements);
			break;
		case TRIANGLE:
			shape= new Triangle(point, measurements);
			break;
		}
		return shape;
	}
}
