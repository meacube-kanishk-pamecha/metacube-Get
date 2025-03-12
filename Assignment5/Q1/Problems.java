package Q1;

public class Problems {

  /**
   * HCF finds the Highest common Factor
   * 
   * @param int x one of the input positive integer
   * @param int y another positive integer
   * @return HCF of the two number
   * @throws AssertionError
   */
  protected int HCF(int x, int y) throws AssertionError {
    if (x < 1 || y < 1)
      throw new AssertionError("Invalid Number");
    if (x % y == 0)
      return y;
    return HCF(y, x % y);
  }

  /**
   * Min returns the number which is smaller
   * 
   * @param int x one of the input to be checked
   * @param int y another input to be checked
   * @return int Minimum of the both number is returned
   */
  protected int Min(int x, int y) {
    // returning the smaller number
    if (x < y)
      return x;
    return y;
  }

  /**
   * LCM produces the lcm of the two number
   * 
   * @param int x one of the input of LCM
   * @param int y another input of LCM
   * @return int LCM of the two number
   */
  protected int LCM(int x, int y) {
    // return the LCM Function
    return LCMFunction(x, y, 2);
  }

  /**
   * LCMFunction finds out the LCM of two numbers
   * 
   * @param int x one of the number of LCM
   * @param int y another number of LCM
   * @param int k increment upto which checking is done
   * @return LCM of the two number
   * @throws AssertionError
   */
  protected int LCMFunction(int x, int y, int k) throws AssertionError {
    //if the input is invalid
    if (x < 1 || y < 1)
      throw new AssertionError("Invalid Input");
    if (x == 1 || y == 1)
      return x * y; // one of the number is 1 so the lcm will be x*y
    if (x == y)
      return x; // if equal then LCM is itself
      // k should be less then  both x and y 
    if (k <= Min(x, y)) {
      // if it divides both x and y return the new LCM of x/y and y/k
      if (x % k == 0 && y % k == 0) {
        return k * LCMFunction(x / k, y / k, 2); // number found start from the 2 after division
      } else {
        return LCMFunction(x, y, k + 1); // no matches find for the next number
      }
    } else
      return x * y; // k> one of the number so it will be x*y
  }

}
