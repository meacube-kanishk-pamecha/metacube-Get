import java.util.Scanner;

public class operations {
    public static void main(String[] args) throws ArithmeticException {
        Marksheet m = new Marksheet();
        Scanner Sc = new Scanner(System.in);
        try {
            System.out.println("My name is kanishk Pamecha");
            System.out.println(" Write the value of n");
            int n = Sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Write the grades here between 1 and 100");
                int a = Sc.nextInt();
                if (a >= 0 && a <= 100) {
                    arr[i] = a;
                } else {
                    System.out.println("Please correct the value it is not Valid!");
                    throw new ArithmeticException("Arithmetic Exception");
                }

            }
            System.out.println("1: Average \n 2: Max \n 3: Min \n 4: Passed Percentage");
            int c = Sc.nextInt();
            switch (c) {
                case 1:
                    System.out.println(m.average(arr));
                    break;
                case 2:
                    System.out.println(m.max(arr));
                    break;
                case 3:
                    System.out.println(m.min(arr));
                    break;
                case 4:
                    System.out.println(m.passed(arr) + "%");
                    break;
                default:
                    break;
            }

        } catch (Exception ArithmeticException) {
            System.out.println("Arithmetic exception detected");
        } finally {
            Sc.close();
        }
    }

}
