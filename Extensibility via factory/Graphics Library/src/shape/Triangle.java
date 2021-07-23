package shape;
import java.time.LocalTime;
import java.util.List;

/**
 * Triangle class with parent class as Shape
 */
public class Triangle implements Shape {

    private int baseSide; // side AB
    private int side2; // side AC
    private int side3; // side BC
	private Point origin;
    private Point A, B, C;
    LocalTime timestamp;

    /**Constructor of the polynomial
   	 * @param origin point of origin
   	 * @param parameters of the Triangle
   	 * @throws IllegalArgumentException
   	 */
    Triangle(Point origin, List<Integer> parameters) {
        if (parameters.size() < 3) {
            throw new IllegalArgumentException();
        }

        this.origin = origin;
        this.baseSide = parameters.get(0);
        this.side2 = parameters.get(1);
        this.side3 = parameters.get(2);
        this.timestamp = LocalTime.now();

        if (!isValidTriangle(baseSide, side2,
                side3)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        return calculateArea(baseSide,side2,side3);
    }
  
    /**Calculate the area of the triangle
     * @param side1 side of the triangle
     * @param side2 side of the triangle
     * @param side3 side of the triangle
     * @return calculated area
     */
    private double calculateArea(double side1, double side2, double side3) {
    	  double semiperimeter = (baseSide + side2 + side3) / 2;
          // Heron's formulae
          // area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
          double area =
                  Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2)
                          * (semiperimeter - side3));
        return area;
    }

    @Override
    public double getPerimeter() {
        return baseSide + side2 + side3;
    }

    @Override
    public Point getOrigin() {

        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        if (A == null || B == null || C == null) {
            setCornerPoints();
        }

        double verySmallDifference = 0.1;
        // suppose triangle is ABC and point is P
        Point P = point;
        double AB = baseSide;
        double AC = side2;
        double BC = side3;

        double PA = calculateDistance(P, A);
        double PB = calculateDistance(P, B);
        double PC = calculateDistance(P, C);

        double areaPAB = calculateArea(PA, PB, AB);
        double areaPBC = calculateArea(PB, PC, BC);
        double areaPAC = calculateArea(PA, PC, AC);
        double areaABC = getArea();

        if (Math.abs(areaPAB + areaPBC + areaPAC - areaABC) < verySmallDifference) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set Corner with of the triangle
     */
    private void setCornerPoints() {
        A = new Point(origin.getX(), origin.getY());
        B = new Point(A.getX() + baseSide, A.getY());
        double area = getArea();
        double height = (2 * area) / baseSide;
        double xOfBaseOfPerpendicularFromC =
                Math.sqrt(Math.pow(side2, 2) - Math.pow(height, 2))
                        + A.getX();
        C = new Point((int)xOfBaseOfPerpendicularFromC,(int)(A.getY() + height));
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

    /** Check i sValid Triangle of not 
     * @param side1 side of triangle
     * @param side2 side of triangle
     * @param side3 side of triangle
     * @return true if triangle
     */
    private boolean isValidTriangle(int side1, int side2, int side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            return false;
        }
        if (side1 > side2 + side3 || side2 > side1 + side3 || side3 > side1 + side2) {
            return false;
        }

        return true;
    }

	@Override
	public Shape.ShapeType getShapeType() {
		return Shape.ShapeType.TRIANGLE;
	}

	@Override
	public LocalTime getTimeStamp() {
		return timestamp;
	}
}