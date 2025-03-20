import java.time.LocalDateTime;
public class RegularPolygon implements Shapes {
    

    
        private Point origin;
        private double length;
        private int side;
        private LocalDateTime dt;
    
        /** 
         * Constructor for thr RegularPolygon
         */
        public RegularPolygon(Point origin, double length, int sides, LocalDateTime dt) {
            this.origin = origin;
            this.length = length;
            this.side = sides;
            this.dt = dt;
        }
    
        /**
         * isPointEnclosed checks for the point if that is inside this shape or not
         * @param Point p to be checked for this shape
         * @return boolean true if the point is inside the shape else false
         */
        public boolean isPointEnclosed(Point p) {
            if (p.x >= origin.x && p.x <= origin.x + length && p.y >= origin.y && p.y <= origin.y + length)
                return true;
            return false;
        }
    
        /** 
         * getter for the name
         */
        public ShapeTypes getName() {
            return ShapeTypes.REGULAR_POLYGON;
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
            return (side * (length * length)) / (4.0 * Math.tan((Math.PI / side)));
        }
    
        /**
         * getPerimeter return the area of the shape
         * @return double Perimeter of the shape
         */
        public double getPerimeter() {
            return side* (length);
        }
    
        /** 
         * getter for the origin point
         */
        public Point getOrigin() {
            return origin;
        }
    }
    