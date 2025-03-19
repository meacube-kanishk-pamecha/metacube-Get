import java.time.LocalDateTime;

public class Circle implements Shapes {
    private Point origin;
    private double radius;
    private LocalDateTime dt;

    //constructor for the circle shape
    public Circle(Point origin, double radius, LocalDateTime dt) {
        this.origin = origin;
        this.radius = radius;
        this.dt = dt;
    }

    /**
     * isPointEnclosed checks for the point if that is inside this shape or not
     * @param Point p to be checked for this shape
     * @return boolean true if the point is inside the shape else false
     */
    public boolean isPointEnclosed(Point p) {

        if (Math.pow((p.x - origin.x), 2) +
                Math.pow((p.y - origin.y), 2) <= Math.pow(radius, 2))
            return true;
        else
            return false;
    }

    /**
     * getter for the name
     */
    public ShapeTypes getName() {
        return ShapeTypes.CIRCLE;
    }

    /**
     * getterfor the date time
     */
    public LocalDateTime getDt() {
        return dt;
    }

    /**
     * getArea return the area of the shape
     * @return double area of the shape
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * getPerimeter return the area of the shape
     * @return double perimeter of the shape
     */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * getter for the origin point
     */
    public Point getOrigin() {
        return origin;
    }
}
