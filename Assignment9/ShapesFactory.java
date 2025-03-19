import java.time.LocalDateTime;
import java.util.List;


public class ShapesFactory {
    /**
     * createShape it return a object of the specific input type
     * @param  String type the type of object that is to be created
     * @param Point origin  the point os origin 
     * @param  List<Double> params that are to be provided for the object creation
     * @return Object of Shape with the type of shape
     */
    public static Shapes createShape(String type, Point origin, List<Double> params) {
        LocalDateTime lt = LocalDateTime.now();
        // switch case to checked which type of object is to be created
        switch (type.toLowerCase()) {
             case "circle":
                return new Circle(origin, params.get(0),lt);
            case "square":
                return new Square(origin, params.get(0),lt);
            case "rectangle":
                return new Rectangle(origin, params.get(0), params.get(1),lt);
            case "triangle":
                return new Triangle(origin,origin,origin, params.get(0), params.get(1),lt);
            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}

