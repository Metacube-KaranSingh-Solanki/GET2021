package shape;
import java.time.LocalTime;
import java.util.List;

/**Square class with parent class as Shape*/
public class Square implements Shape{
    private int width;
    Point origin;
	LocalTime timestamp;
	
	 /**Constructor of the polynomial
		 * @param origin point of origin
		 * @param parameters  of the square: side
		 * @throws IllegalArgumentException
		 */
    public Square(Point origin, List<Integer> parameters) {
    	if (parameters.size() < 1) {
            throw new IllegalArgumentException();
        }

        this.origin = origin;
        this.width = parameters.get(0);
        timestamp = LocalTime.now();
  
        if (width < 0) {
            throw new IllegalArgumentException();
        }
    }
    
    @Override
    public double getArea(){
        return width*width;
    }
    
    @Override
    public double getPerimeter() {
        return 4*width;
    }

    @Override
    public Shape.ShapeType getShapeType() {
        return Shape.ShapeType.SQUARE;
    }
    
    @Override
	public Point getOrigin() {
		return origin;
	}
	
    @Override
    public boolean isPointEnclosed(Point point1) {
		int x = point1.getX();
		int y = point1.getY();
		int x1 = origin.getX();
		int y1 = origin.getY();
		int x2 = x1 + width;
		int y2 = y1 + width;
		
		return (x > x1 && x < x2 && y > y1 && y < y2);
	}

	@Override
	public LocalTime getTimeStamp() {
		return timestamp;
	}
}
