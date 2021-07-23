package shape;
import java.time.LocalTime;
import java.util.List;


/**
 * Circle class with parent class as Shape
 */
public class Circle implements Shape{
	Point center;
	int radius;
	Point origin;
	LocalTime timestamp;
	
	/**Constructor of the polynomial
	 * @param origin point of origin
	 * @param parameters radius of circle
	 * @throws IllegalArgumentException
	 */
	Circle(Point origin, List<Integer> parameters) throws IllegalArgumentException {
        this.origin = origin;
        this.radius = parameters.get(0);
		timestamp = LocalTime.now();

		setCenterPoint();

        if (radius < 0) {
            throw new IllegalArgumentException();
        }
    }
	
	/**
	 * Find the center point of the circle
	 */
	public void setCenterPoint() {
        double x1 = origin.getX();
        double y1 = origin.getY();
        double r = this.radius;
        double x1Squared = Math.pow(x1, 2);
        double y1Squared = Math.pow(y1, 2);
        double eq1 = x1Squared + y1Squared;
        double eq2 = -1 * ((2 * x1 * y1Squared) + (2 * Math.pow(x1, 3)));
        double eq3 = (x1Squared * y1Squared) + Math.pow(x1, 4) - (Math.pow(r, 2) * x1Squared);
        double D = Math.pow(eq2, 2) - 4 * eq1 * eq3;
        double x = (-1 * eq2 + Math.pow(D, 0.5)) / (2 * eq1);
        double y = (y1 / x1) * x;

		center = new Point((int)x, (int)y);
    }

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public Shape.ShapeType getShapeType() {
		return Shape.ShapeType.CIRCLE;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}
	

	@Override
	public boolean isPointEnclosed(Point point) {
		if ((point.getX() - center.getX()) * (point.getX() - center.getX()) +
            (point.getY() - center.getY()) * (point.getY() - center.getY()) <= radius * radius)
            return true;
        else
            return false;
	}
	
	@Override
	public LocalTime getTimeStamp() {
		return timestamp;
	}
}
