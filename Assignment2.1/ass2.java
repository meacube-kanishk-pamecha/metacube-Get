import java.util.Scanner;

class ass2 {
    public static void main(String[] args) {
        Operations op = new Operations();
        Scanner Sc = new Scanner(System.in);
        String num1 = "";
        String num2 = "";
        int dec = 0;
        System.out.println(
                " 1 : Add \n 2 : Subtract \n 3 : Multiplication \n 4 : Division \n 5 : Equals \n 6 : greater \n 7 : Smaller  \n 8 : Hex to Dec \n 9 : Dec to Hex");
        int ni = Sc.nextInt();
        if (ni == 8) {
            System.out.println("Enter the  hexadecimal Number ");
            num1 = Sc.next();
        }
        if (ni == 9) {
            System.out.println("Enter the decimal Number ");
            dec = Sc.nextInt();
        }
    if(ni!=8 && ni!=9)
      {  System.out.println("Enter the 1 hexadecimal Number ");
        num1 = Sc.next();
        System.out.println("Enter the 2 hexadecimal Number ");
        num2 = Sc.next();
    }
        switch (ni) {
            case 1:
                System.out.println(op.addition(num1, num2));
                break;
            case 2:
                System.out.println(op.subtract(num1, num2));
                break;
            case 3:
                System.out.println(op.multiplication(num1, num2));
                break;
            case 4:
                System.out.println(op.division(num1, num2));
                break;
            case 5:
                System.out.println(op.equals(num1, num2));
                break;
            case 6:
                System.out.println(op.greater(num1, num2));
                break;
            case 7:
                System.out.println(op.smaller(num1, num2));
                break;
            case 8:
                System.out.println(op.convertHexToDec(num1));
                break;
            case 9:
                System.out.println(op.convertDecToHex(dec));
                break;
            default:
                System.out.println("Enetr from the option");
                break;
        }
    
        Sc.close();
    }

}