public class Operations {

    protected String addition(String num1, String num2) {
        int a = convert(num1);
        int b = convert(num2);
        int c = a + b;
        return reConvert(c);
    }

    protected String subtract(String num1, String num2) {
        int a = convert(num1);
        int b = convert(num2);
        int c = a - b;
        return reConvert(c);
    }

    protected String multiplication(String num1, String num2) {
        int a = convert(num1);
        int b = convert(num2);
        int c = a * b;
        return reConvert(c);
    }

    protected String division(String num1, String num2) {
        int a = convert(num1);
        int b = convert(num2);
        int c = a / b;
        return reConvert(c);
    }

    // hexadecimal String to int decimal
    protected int convert(String a) {
        int length = a.length();
        int decimal = 0;
        int base = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (a.charAt(i) >= '0' && a.charAt(i) <= '9') {
                decimal += ((a.charAt(i) - '0') * base);
                base *= 16;
            } else if (a.charAt(i) >= 'A' && a.charAt(i) <= 'F') {
                decimal += ((a.charAt(i) - 'A' + 10) * base);
                base *= 16;
            } else {
                System.out.print("Error! use good hexadecimal Numbers");
            }

        }
        return decimal;
    }

    // Conversion from decimal to hexadecimal
    protected String reConvert(int a) {
        boolean neg = false;
        if (a < 0) {
            neg = true;
            a = a * -1;
        }
        if(a==0) return "0";
        StringBuilder s = new StringBuilder();
        int c = a;
        while (c != 0) {
            int num = c % 16;
            if (num < 10)
                s.append(num);
            else
                s.append((char) (num + 'A' - 10));
            c = c / 16;

        }
        if (neg) {
            StringBuilder newstr = new StringBuilder(s.toString().concat("-"));
            return newstr.reverse().toString();
        }
        return s.reverse().toString();
    }

    // checking equals
    protected boolean equals(String num1, String num2) {
        return num1.equals(num2);

    }

    // checking small
    protected boolean smaller(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        if (l1 > l2)
            return false;
        if (l1 < l2)
            return true;
        if (num1.equals(num2))
            return false;
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        for (int i = 0; i < l1; i++) {
            if (arr1[i] > arr2[i])
                return false;
        }
        return true;
    }

    // checking for smaller
    protected boolean greater(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        if (l1 < l2)
            return false;
        if (l1 > l2)
            return true;
        if (num1.equals(num2))
            return false;
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        for (int i = 0; i < l1; i++) {
            if (arr1[i] < arr2[i])
                return false;
        }
        return true;
    }
}
