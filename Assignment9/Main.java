import java.util.List;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();

        Shapes circle = ShapesFactory.createShape("circle", new Point(2, 3), List.of(5.0));
        Shapes square = ShapesFactory.createShape("square", new Point(5, 5), List.of(5.0));
        Shapes circle1 = ShapesFactory.createShape("circle", new Point(1, 3), List.of(100.0));
        Shapes circle2 = ShapesFactory.createShape("circle", new Point(8, 3), List.of(20.0));
        screen.addShape(circle);
        screen.addShape(square);
        screen.addShape(circle1);
        screen.addShape(circle2);
        screen.shapesAtPoit(new Point(500, 50));
        screen.show();
    }
}
