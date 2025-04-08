package Mass;

public class MolecularMass {
    final static int C = 12;
    final static int O = 16;
    final static int H = 1;

    /**
     * mass for the given char array it find the molecular mass
     * 
     * @param char [] c an array of character which contains the string combined
     * @param int  start represents the position from where the array is to be
     *             checked
     * @param int  end represents upto where the char array is to be iterated
     * @return int the total molecular mass of the components from start to end
     */
    public static int mass(char[] c, int start, int end) {
        int ans = 0; // final ans
        int currnum = 0; // temp or current ans

        // getting the mass from start to end of the given index
        for (int i = start; i < end; i++) {
            // checking for a different molecule like C(CH)3
            if (c[i] == '(') {
                ans += currnum;
                int last = -1;
                // checking upto where this mole is to be . end index of the paranth.
                for (int j = i; j < c.length; j++) {
                    if (c[j] == ')') {
                        last = j;
                        break;
                    }
                }
                // if no closing paran. found it means there is mistake present
                if (last == -1) {
                    System.out.println("Problem Found");
                    return -1;
                }

                currnum = mass(c, i + 1, last);
                i = last;
            }

            // if it the current char is digit it is to be multiplied with curr ans
            else if (Character.isDigit(c[i])) {
                currnum *= (c[i] - '0');
            } else if (c[i] == 'C') { // if it is a molecule of atoms.
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
        // adding the curr ans to final ans and returning it
        ans += currnum;
        return ans;
    }

    /**
     * molecularMass find the molecular mass by calling mass in specified manner
     * (Calling method of mass)
     * 
     * @param String s the String is the molecule
     * @return int return molecular mass of the molecule
     */
    public static int molecularMass(String s) {
        return mass(s.toCharArray(), 0, s.length());
    }
}
