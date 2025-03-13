package Q2;

import java.util.Arrays;

public class Poly {
    private int[] coeff;

    /**
     * Poly Constructor which is to be used while creating the object
     * 
     * @param int []arr it takes integer array as the input
     */
    Poly(int[] arr) {
        coeff = Arrays.copyOf(arr, arr.length);
    }

    /**
     * it overides the toString function when printed it prints it
     */
    @Override
    public String toString() {
        return Arrays.toString(coeff);
    }

    /**
     * Eval function it evaluates the current polynomial with the help of given
     * value
     * 
     * @param int x it represents the value of x
     * @return float or the value after calculating the polynomial function
     */
    float Eval(float x) {
        float ans = 0;
        float pow = 1;
        for (int i : coeff) {
            ans += i * pow;
            pow *= x;
        }
        return ans;

    }

    /**
     * max gives the max size from both the polynomial
     * 
     * @param Poly p1 one of the Polynomial of type Poly
     * @param Poly p2 another Polynomial of type Poly
     * @return int max size of the polynomial or the coeff array
     */
    private int max(Poly p1, Poly p2)

    {
        return (Math.max(p1.coeff.length, p2.coeff.length));
    }

    /**
     * add the polynomial given to it
     * 
     * @param Poly p1 one of the polynomial of the to be added
     * @param Poly p2 another polynomial to be added
     * @return Poly new Poly which is the addition of the above two polynomial
     */
    Poly add(Poly p1, Poly p2) {
        int max = max(p1, p2);
        int[] newarr = new int[max];
        // loop to iterate upto the max value from both of the polynomial
        for (int i = 0; i < max; i++) {
            // if both are in the range
            if (i < p1.coeff.length && i < p2.coeff.length) {
                newarr[i] = (p1.coeff[i] + p2.coeff[i]);

            }
            // if one of them is not in the range of i
            else if (p1.coeff.length - 1 < i) {
                newarr[i] = (p2.coeff[i]);

            }
            // if another is not in the rangr of i
            else if (p2.coeff.length - 1 < i) {
                newarr[i] = (p1.coeff[i]);

            }

        }
        return new Poly(newarr); // return a new polyof the newarr.
    }

    /**
     * multiPoly it is used for multiplication of two polynomials
     * 
     * @param Poly p1 one of the polynomial that is to be multiplied
     * @param Poly p2 another polynomial that is to be multiplied
     * @return a new polynomial with the multiplied
     */
    Poly multiPoly(Poly p1, Poly p2) {
        int base = 0;
        int[] newarr = new int[p1.coeff.length - 1 + p2.coeff.length];
        // loop for the p1 polynomial
        for (int i = 0; i < p1.coeff.length; i++) {
            // loop for the p2 polynomial
            for (int j = 0; j < p2.coeff.length; j++) {
                // saving the multiplication to the new array
                newarr[base + j] += (p1.coeff[i] * p2.coeff[j]);
            }
            base++;
        }
        return new Poly(newarr);
    }

    /**
     * degree it is used to represent the degree of the polynomial
     * 
     * @param Poly p1 to show the degree of inputed polynomial
     * @return int or the return the degree of the polynomial
     */
    int degree(Poly p1) {
        boolean ans = true;
        int deg = p1.coeff.length - 1;
        // looping through the array to see the degree of the polynomial
        for (int i = p1.coeff.length - 1; i >= 0; i--) {
            if (ans && p1.coeff[i] == 0)
                deg--;
            else
                ans = false;
        }
        return deg;

    }

    /**
     * represents it is used to represent the current object in polynomial form
     */
    void represents() {
        int pow = 0;
        // looping through the array so that represent in the form of polynomial
        // function
        for (int i = 0; i < coeff.length; i++) {
            System.out.print(coeff[i] + "x^" + pow);
            if (i != coeff.length - 1)
                System.out.print(" + ");
            pow++;
        }
    }

    
}