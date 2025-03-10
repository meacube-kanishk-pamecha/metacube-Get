import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("To Calculate the area we are here ");
        Scanner Sc = new Scanner(System.in);
        try {
            Area a = new Area();
            System.out.println("To Calculate press \n 1: Triangle \n 2: Rectangle \n 3:Square \n 4:Circle");
            int c = Sc.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Input height and base ");
                    int h = Sc.nextInt();
                    int b = Sc.nextInt();
                    System.out.println(a.triangle(h, b));
                    break;
                case 2:
                    System.out.println("Input height and width");
                    h = Sc.nextInt();
                    b = Sc.nextInt();
                    System.out.println(a.rectangle(h, b));
                    break;
                case 3:
                    System.out.println("Input Side of the square");
                    h = Sc.nextInt();
                    System.out.println(a.square(h));
                    break;
                case 4:
                    System.out.println("Radius of the circle");
                    int r = Sc.nextInt();
                    System.out.println(a.circle(r));
                    break;

                default:
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println("Exception Found" + e.getMessage());
        } finally {
            Sc.close();
        }
    }

}
