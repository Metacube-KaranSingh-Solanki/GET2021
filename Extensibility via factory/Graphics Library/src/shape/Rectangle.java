package shape;
import java.time.LocalTime;
import java.util.List;


/**
 * Rectangle class with parent class as Shape
 */
public class Rectangle implements Shape{
    private int height, width;
    Point origin;
	LocalTime timestamp;
	
	/**Constructor of the polynomial
	 * @param origin point of origin
	 * @param parameters of the rectangle
	 * @throws IllegalArgumentException
	 */
    Rectangle(Point origin, List<Integer> parameters) throws IllegalArgumentException {
        if (parameters.size() < 2) {
            throw new IllegalArgumentException();
        }

        this.origin = origin;
        this.width = parameters.get(0);
        this.height = parameters.get(1);
        timestamp = LocalTime.now();

        if (width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
    }
    

    @Override
    public double getArea(){
        return width*height;
    }
    
    @Override
    public double getPerimeter() {
        return 2*(width + height);
    }
    
    @Override
    public Shape.ShapeType getShapeType() {
        return Shape.ShapeType.RECTANGLE;
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
		int x2 = x1 + height;
		int y2 = y1 + width;
		
		return (x > x1 && x < x2 && y > y1 && y < y2);
	}


	@Override
	public LocalTime getTimeStamp() {
		return timestamp;
	}
}
