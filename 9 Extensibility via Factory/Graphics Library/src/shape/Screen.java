package shape;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

public class Screen {
	List<Shape> shapes;
	
	public Screen() {	
		shapes = new ArrayList<Shape>();
	}

	/**
	 * Add a shape object to the screen at a specified location
	 * @param shape
	 * @return true if success, false if not
	 */
	public boolean addShape(Shape shape) {
		if (!shapes.contains(shape)) {
			shapes.add(shape);
			return true;
		}
		return false;
	}

	/**
	 * Delete a shape object from the screen
	 * @param shape
	 * @return true if success, false if not
	 */
	public boolean deleteShape(Shape shape) {
		if (shapes.contains(shape)) {
			shapes.remove(shape);
			return true;
		}
		return false;
	}

	/**
	 * Delete all shape objects of a specific type
	 * @param shapeType
	 */
	public void deleteAllShapes(Shape.ShapeType shapeType) {
		Iterator<Shape> iterator = shapes.iterator();
		while (iterator.hasNext()) {
			Shape shape = iterator.next();
			if (shape.getShapeType() == shapeType) {
				iterator.remove();
			}
		}
	}

	/**
	 * Return the shape objects on the screen sorted in desired ascending order
	 * based on area, perimeter, timestamp or origin distance (distance of the
	 * origin of the shape from the origin of the screen) with various design
	 * options for this method.
	 * @param shapeType
	 * @return Shape List
	 */
	public List<Shape> sortShape(SortType sortType) {
		List<Shape> sortedShapes = null;
		
		if(shapes.isEmpty())
			throw new AssertionError("Can't sort empty list.");
		
		switch(sortType){
			case AREA:
				sortedShapes = getShapesSortedByArea();
				break;
			case PERIMETER:
				sortedShapes = getShapesSortedByPerimeter();
				break;
			case TIMESTAMP:
				sortedShapes = getShapesSortedByTimestamp();
				break;
			case ORIGIN_DISTANCE:
				sortedShapes = getShapesSortedByOriginDistance();
				break;
		}
		return sortedShapes;
	}

	/**
	 * The list of shape objects enclosing a specified point
	 * @param point point where point of enclosing shapes need to be found.
	 * @return Shape List
	 */
    public List<Shape> getEnclosingShapes(Point point) {
        List<Shape> enclosingShapes = new ArrayList<Shape>();
        for (Shape shape : shapes) {
            if (shape.isPointEnclosed(point)) {
                enclosingShapes.add(shape);
            }
        }
        return enclosingShapes;
    }
	
    /**
	 * Method to sort by Area
	 * @return List of shape
	 */
    public List<Shape> getShapesSortedByArea() {
		List<Shape> list = new ArrayList<Shape>();
		list.addAll(this.shapes);
		Collections.sort(list, new Comparator<Shape>() {
			@Override
			public int compare(Shape shape1, Shape shape2) {
				// Comparison based on area
				double area1 = shape1.getArea();
				double area2 = shape2.getArea();

				return (int) (area1 - area2);
			}
		});

		return list;
	}
    
    /**
	 * Method to sort by Perimeter
	 * @return List of shape
	 */
	public List<Shape> getShapesSortedByPerimeter() {
		List<Shape> list = new ArrayList<Shape>();
		list.addAll(this.shapes);
		Collections.sort(list, new Comparator<Shape>() {
			@Override
			public int compare(Shape shape1, Shape shape2) {
				// Comparison based on perimeter
				double p1 = shape1.getPerimeter();
				double p2 = shape2.getPerimeter();

				return (int) (p1 - p2);
			}
		});
		return list;
	}

	/**
	 * Method to sort by Timestamp
	 * @return List of shape
	 */
	public List<Shape> getShapesSortedByTimestamp() {
		List<Shape> list = new ArrayList<Shape>();
		list.addAll(this.shapes);
		Collections.sort(list, new Comparator<>() {
			@Override
			public int compare(Shape shape1, Shape shape2) {
				// Comparison based on time stamp
				LocalTime t1 = shape1.getTimeStamp();
				LocalTime t2 = shape2.getTimeStamp();

				return t1.compareTo(t2);
			}
		});
		return list;
	}
	
	/**
	 * Method to sort by originDistance
	 * @return List of shape
	 */
	public List<Shape> getShapesSortedByOriginDistance() {
		List<Shape> list = new ArrayList<Shape>();
		list.addAll(this.shapes);
		Collections.sort(list, new Comparator<>() {
			@Override
			public int compare(Shape shape1, Shape shape2) {
				double distance1Squared = Math.pow(shape1.getOrigin().getX(), 2)
						+ Math.pow(shape1.getOrigin().getY(), 2);
				double distance1 = Math.sqrt(distance1Squared);
				double distance2Squared = Math.pow(shape2.getOrigin().getX(), 2)
						+ Math.pow(shape2.getOrigin().getY(), 2);
				double distance2 = Math.sqrt(distance2Squared);

				return Double.compare(distance1, distance2);
			}
		});
		return list;
	}
}
