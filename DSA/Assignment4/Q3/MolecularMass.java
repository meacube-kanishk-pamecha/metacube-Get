package Q3;

public class MolecularMass {
    final static int C = 12;
    final static int O = 16;
    final static int H = 1;

    public static int mass(char[] c, int start, int end) {
        int ans = 0;
        int currnum = 0;
        for (int i = start; i < end; i++) {
            if (c[i] == '(') {
                ans += currnum;
                int endDa = -1;
                for (int j = i; j < c.length; j++) {
                    if (c[j] == ')') {
                        endDa = j;
                        break;
                    }
                }
                if (endDa == -1) {
                    System.out.println("Problem Found");
                    return -1;
                }

                currnum = mass(c, i + 1, endDa);
                i = endDa;
            }

            else if (Character.isDigit(c[i])) {
                currnum *= (c[i] - '0');
            } else if (c[i] == 'C') {
                ans += currnum;
                currnum = C;
            } else if (c[i] == 'O') {
                ans += currnum;
                currnum = O;
            } else if (c[i] == 'H') {
                ans += currnum;
                currnum = 1;
            }
        }
        ans += currnum;
        return ans;
    }

    public static int molecularMass(String s) {
        return mass(s.toCharArray(), 0, s.length());
    }
}
