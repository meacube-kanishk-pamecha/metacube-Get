import java.util.List;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();

        Shapes circle = ShapesFactory.createShape(ShapeTypes.CIRCLE, new Point(2, 3), List.of(5.0));
        Shapes square = ShapesFactory.createShape(ShapeTypes.SQUARE, new Point(5, 5), List.of(5.0));
        Shapes circle1 = ShapesFactory.createShape(ShapeTypes.CIRCLE, new Point(1, 3), List.of(100.0));
        Shapes circle4 = ShapesFactory.createShape(ShapeTypes.REGULAR_POLYGON, new Point(8, 3), List.of(20.0));
        screen.addShape(circle);
        screen.addShape(square);
        screen.addShape(circle1);
        screen.addShape(circle4);
        screen.deleteAll(ShapeTypes.CIRCLE);
        screen.shapesAtPoit(new Point(5, 5));
        screen.show();
    }
}
