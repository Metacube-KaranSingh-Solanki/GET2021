package shape;
import java.time.LocalTime;
import java.util.List;


/**
 * Regular class with parent class as Shape
 */
public class RegularPolygon implements Shape {

	private Point origin;
    private int numberOfSides;
    private int sideLength;
    private Point[] points;
    private Point center;
    private double apothem;
    private double radius;
    private LocalTime timestamp;

    /**Constructor of the polynomial
	 * @param origin point of origin
	 * @param parameters of the RegularPolygon
	 * @throws IllegalArgumentException
	 */
    RegularPolygon(Point origin, List<Integer> parameters) throws IllegalArgumentException {
        if (parameters.size() < 2) {
            throw new IllegalArgumentException();
        }

        this.origin = origin;
        this.numberOfSides = parameters.get(0);
        this.sideLength = parameters.get(1);
        timestamp = LocalTime.now();

        if (numberOfSides < 0 || sideLength < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        if (points == null) {
            setApothemRadiusCenterAndPoint();
        }
        return numberOfSides * (0.5 * sideLength * apothem);
    }

    @Override
    public double getPerimeter() {
        return numberOfSides * sideLength;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        double area = 0;
        double verySmallDifference = 0.1;

        if (points == null) {
            setApothemRadiusCenterAndPoint();
        }

        for (int i = 0; i < points.length - 1; i++) {
            area += calculateAreaOfTriangle(point, points[i], points[i + 1]);
        }

        area += calculateAreaOfTriangle(point, points[points.length - 1], points[0]);

        if (Math.abs(area - this.getArea()) < verySmallDifference) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set the RadiusCenter and points
     */
    private void setApothemRadiusCenterAndPoint() {
        double internalAngle = (2 * Math.PI) / numberOfSides;
        apothem = ((double) sideLength) / (2 * Math.tan(internalAngle / 2));
        radius = ((double) sideLength) / (2 * Math.sin(internalAngle / 2));
        center = new Point((int)(origin.getX() + sideLength / 2.0), (int)(origin.getY() + apothem));
        points = new Point[numberOfSides];
        double angle = Math.PI + internalAngle / 2.0;
        for (int i = 0; i < points.length; i++) {
            points[i] =
                    new Point((int)(center.getX() + radius * Math.sin(angle)), (int)(center.getY()
                            + radius * Math.cos(angle)));
            angle += internalAngle;
        }
    }

    /**Calculate are of triangle
     * @param A side of triangle
     * @param B side of triangle
     * @param C side of triangle
     * @return area of triangle
     */
    private double calculateAreaOfTriangle(Point A, Point B, Point C) {
        double AB = calculateDistance(A, B);
        double BC = calculateDistance(B, C);
        double AC = calculateDistance(A, C);
        return calculateAreaOfTriangle(AB, BC, AC);
    }

    /** Calculate the distance between two points
     * @param A point 
     * @param B point
     * @return distance between two points
     */
    private double calculateDistance(Point A, Point B) {
        return Math.sqrt(Math.pow(A.getX() - B.getX(), 2)
                + Math.pow(A.getY() - B.getY(), 2));
    }

    private double calculateAreaOfTriangle(double side1, double side2, double side3) {
        double semiperimeter = (side1 + side2 + side3) / 2;
        double area =
                Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2)
                        * (semiperimeter - side3));
        return area;
    }

	@Override
	public Shape.ShapeType getShapeType() {
		return Shape.ShapeType.REGULAR_POLYGON;
	}

	@Override
	public LocalTime getTimeStamp() {
		return timestamp;
	}
}