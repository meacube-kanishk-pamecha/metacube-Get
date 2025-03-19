import java.time.LocalDateTime;

public class Square implements Shapes {
    private Point origin;
    private double side;

    private LocalDateTime dt;

    // Constructor for the shape Square
    public Square(Point origin, double side, LocalDateTime dt) {
        this.origin = origin;
        this.side = side;
        this.dt = dt;
    }

    /**
     * getter for Name
     */
    public String getName() {
        return "Square";
    }

    /**
     * isPointEnclosed checks for the point if that is inside this shape or not
     * @param Point p to be checked for this shape
     * @return boolean true if the point is inside the shape else false
     */
    public boolean isPointEnclosed(Point p) {
        // checking if the point is inside the shape 
        if (p.x >= origin.x && p.x <= origin.x + side && p.y >= origin.y && p.y <= origin.y + side)
            return true;
        return false;
    }

    /**
     * getter for the date and tiem
     */
    public LocalDateTime getDt() {
        return dt;
    }

    /**
     * getArea return the area of the shape
     */
    public double getArea() {
        return side * side;
    }

    /**
     * getPerimeter returns the perimeter of the shape
     */
    public double getPerimeter() {
        return 2 * (side + side);
    }

    /**
     * getter for the origin point
     */
    public Point getOrigin() {
        return origin;
    }
}
