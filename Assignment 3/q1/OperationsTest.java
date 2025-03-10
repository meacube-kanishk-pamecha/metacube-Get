import java.util.Scanner;

public class OperationsTest {
    public static void main(String[] args) {
        Operations op = new Operations();
        Scanner Sc = new Scanner(System.in);
        System.out.println(" Write the input String");
        String str = Sc.nextLine();
        System.out.println("1 : largestWord 2 : equals 3 : reverse 4 : caseChange ");
        int option = Sc.nextInt();

        switch (option) {
            case 1:
                System.out.println(op.largestWord(str));
                break;
            case 2:
                System.out.println("Enter the other String ");
                Sc.nextLine();
                String str2 = Sc.nextLine();
                System.out.println(op.equals(str, str2));
                break;
            case 3:
                System.out.println(op.reverse(str));
                break;
            case 4:
                System.out.println(op.caseChange(str));
                break;

            default:
                break;
        }

        Sc.close();

    }
}
