import java.time.LocalDateTime;

public class Rectangle implements Shapes {
    private Point origin;
    private double length, width;

    private LocalDateTime dt;

    /** 
     * Constructor for thr Rectangle shape
     */
    public Rectangle(Point origin, double length, double width, LocalDateTime dt) {
        this.origin = origin;
        this.length = length;
        this.width = width;

        this.dt = dt;
    }

    /**
     * isPointEnclosed checks for the point if that is inside this shape or not
     * @param Point p to be checked for this shape
     * @return boolean true if the point is inside the shape else false
     */
    public boolean isPointEnclosed(Point p) {
        if (p.x >= origin.x && p.x <= origin.x + width && p.y >= origin.y && p.y <= origin.y + length)
            return true;
        return false;
    }

    /** 
     * getter for the name
     */
    public ShapeTypes getName() {
        return ShapeTypes.RECTANGLE;
    }

    /**
     * getter for the date time
     */
    public LocalDateTime getDt() {
        return dt;
    }
    
    /**
     * getArea return the area of the shape
     * @return double area of the shape
     */
    public double getArea() {
        return length * width;
    }

    /**
     * getPerimeter return the area of the shape
     * @return double Perimeter of the shape
     */
    public double getPerimeter() {
        return 2 * (length + width);
    }

    /** 
     * getter for the origin point
     */
    public Point getOrigin() {
        return origin;
    }
}
