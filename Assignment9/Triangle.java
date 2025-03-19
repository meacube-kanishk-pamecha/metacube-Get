import java.time.LocalDateTime;

public class Triangle implements Shapes {
    private Point origin;
    private Point p2;
    private Point p3;
    private double base, height;

    private LocalDateTime dt;

    // constructor for the Triangle shape
    public Triangle(Point origin, Point p2, Point p3, double base, double height, LocalDateTime dt) {
        this.origin = origin;
        this.p2 = p2;
        this.p3 = p3;
        this.base = base;
        this.height = height;

        this.dt = dt;
    }

    /**
     * getter for the name
     */
    public ShapeTypes getName() {
        return ShapeTypes.TRIANGLE;
    }

    /**
     * getter  for the point p2
     * @return Point p2 
     */
    public Point getP2() {
        return p2;
    }

    /**
     * getter for the point p3
     * @return Point p3
     */
    public Point getP3() {
        return p3;
    }

    /**
     * isPointEnclosed function checks the the point is inside this or not
     * @param Point p the point which is to be checked
     * @return boolean as the true 
     */
    public boolean isPointEnclosed1(Point newPoint) {
        //check for the area from that specific point to all the other side if it is equal to the area of teiangle 
        // return true else return false;
        return true;
    }
 
    static double area(int x1, int y1, int x2, int y2,
    int x3, int y3)
{
return Math.abs((x1*(y2-y3) + x2*(y3-y1)+
x3*(y1-y2))/2.0);
}



public boolean isPointEnclosed(Point  newPoint) {
/* Calculate area of triangle ABC */
double A = area (origin.x, origin.y, p2.x, p2.y, p3.x, p3.y);

/* Calculate area of triangle PBC */ 
double A1 = area (newPoint.x, newPoint.y, p2.x, p2.y, p3.x, p3.y);

/* Calculate area of triangle PAC */ 
double A2 = area (origin.x, origin.y, newPoint.x, newPoint.y, p2.x, p2.y);

/* Calculate area of triangle PAB */  
double A3 = area (origin.x, origin.y, p2.x, p2.y, newPoint.x, newPoint.y);

/* Check if sum of A1, A2 and A3 is same as A */
return (A == A1 + A2 + A3);
}

    /**
     * getter for the date ad time
     */
    public LocalDateTime getDt() {
        return dt;
    }

    /**
     * getArea return the area of the triangle
     */
    public double getArea() {
        return 0.5 * base * height;
    }

    /**
     * getPerimeter return the perimeter of the triangle
     */
    public double getPerimeter() {
        double side = Math.sqrt((base / 2) * (base / 2) + height * height);
        return base + 2 * side;
    }

    /**
     * getter for the origin
     */
    public Point getOrigin() {
        return origin;
    }
}
