import java.util.*;
import java.util.stream.Collectors;

public class Screen {
    private Set<Shapes> shapes = new HashSet<>();

    /**
     * addShape add the shape in the Set Shapes.
     * 
     * @param Shapes shape it is the object to be added in the screen
     */
    public void addShape(Shapes shape) {
        shapes.add(shape);
    }

    /**
     * deleteShape it deletes the shape from the list 
     * 
     * @param Shapes shape object of the shape which is to be removed
     */
    public void deleteShape(Shapes shape) {
        shapes.remove(shape);
    }

    /**
     * deleteAll it deletes the shape of a specific type 
     * 
     * @param String str name of the shape which is to be removed
     */
    public void deleteAll(ShapeTypes str) {
        shapes.removeIf(shape -> shape.getName().equals(str));
    }

    /**
     * 
     * @param p
     */
    public void shapesAtPoit(Point p) {
        List<Shapes> ans = new ArrayList<>();
        for (Shapes shapes2 : shapes) {
            if (shapes2.isPointEnclosed(p)) {
                ans.add(shapes2);
                System.out.println(shapes2.getName());
            }

        }

    }

    /**
     * show return the object of shapes in the list
     */
    public void show() {
        Comparator<Shapes> sortByArea = Comparator.comparing(Shapes::getArea);
        Comparator<Shapes> sortByParameter = Comparator.comparing(Shapes::getPerimeter);
        Comparator<Shapes> sortByDt = Comparator.comparing(Shapes::getDt);
        Comparator<Shapes> sortByDistance = (s1, s2) -> {
            return Double.compare(s1.getOrigin().distance(), s2.getOrigin().distance());
        };
        System.out.println("\n Sorted By Area \n");
        List<Shapes> list = shapes.stream().collect(Collectors.toList());
        Collections.sort(list, sortByArea);

        for (Shapes shapeEntry : list) {
            System.out.println(shapeEntry.getName() + "  " + shapeEntry.getArea());
        }

        System.out.println("\n Sorted by Perimeter\n ");
        List<Shapes> listPeri = shapes.stream().collect(Collectors.toList());
        Collections.sort(listPeri, sortByParameter);

        for (Shapes shapeEntry : listPeri) {
            System.out.println(shapeEntry.getName() + "  " + shapeEntry.getPerimeter());
        }

        System.out.println("\n Sorted by Perimeter\n ");
        List<Shapes> listDt = shapes.stream().collect(Collectors.toList());
        Collections.sort(listDt, sortByDt);

        for (Shapes shapeEntry : listDt) {
            System.out.println(shapeEntry.getName() + "  " + shapeEntry.getDt());
        }

        System.out.println("\n Sorted by Distance \n ");
        List<Shapes> listDistance = shapes.stream().collect(Collectors.toList());
        Collections.sort(listDistance, sortByDistance);

        for (Shapes shapeEntry : listDistance) {
            System.out.println(shapeEntry.getName() + "  " + shapeEntry.getOrigin().distance());
        }
    }

    /**
     * 
     */
   
}
