import java.time.LocalDateTime;

public interface Shapes {
   
    LocalDateTime getDt();
    double getArea();
    double getPerimeter();
    Point getOrigin();
    ShapeTypes getName();
    boolean isPointEnclosed(Point p);
}
