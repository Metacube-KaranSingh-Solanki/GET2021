
public class Area {
	/**
	 * Finds area of triangle
	 * @param height of the triangle, requires height >= 0
	 * @param width of the triangle, requires width >= 0
	 * @return area of triangle
	 * @throws ArithmeticException
	 */
	public double findAreaOfTriangle(double height, double width) throws ArithmeticException{
		return (height * width)/2;
	}
	
	/**
	 * Finds area of rectangle
	 * @param height of the rectangle, requires height >= 0
	 * @param width of the rectangle, requires width >= 0
	 * @return area of rectangle
	 * @throws ArithmeticException
	 */
	public double findAreaOfRectange(double height, double width) throws ArithmeticException {
		return height * width;
	}
	
	/**
	 * Finds area of square
	 * @param width of the square, requires width >= 0
	 * @return area of square
	 * @throws ArithmeticException
	 */
	public double findAreaOfSquare(double width) throws ArithmeticException {
		return width * width;
	}
	
	/**
	 * Finds area of circle
	 * @param radius of the circle, requires width >= 0
	 * @return area of circle
	 * @throws ArithmeticException
	 */
	public double findAreaOfCircle(double radius) throws ArithmeticException {
		return (22 * radius * radius) / 7.0;
	}
}
