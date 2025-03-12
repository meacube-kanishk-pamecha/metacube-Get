package q4;

public class SplitArray {
   /**
    * sum gives the total of input array
    * 
    * @param int [] arr non zero positive integer
    * @return int sum of the full array
    */
   private int sum(int[] arr) {
      int sum = 0;
      for (int i : arr) { // iterator of the full array
         sum += i;
      }

      return sum; // return the sum of the array
   }

   /**
    * split array to be splited in equal halfs.
    * 
    * @param int [] arr
    * @return int where the array is splited into two half
    * @throws AssertionError if the array is Empty
    */
   protected int split(int[] arr) throws AssertionError {
      if (arr.length == 0)
         throw new AssertionError("Empty Array");
      double sum = sum(arr);
      sum = sum / 2;
      double curr = 0;
      for (int i = 0; i < arr.length; i++) // iterate through array
      {

         curr += arr[i];
         if (curr == sum)
            return i + 1;
         if (curr > sum)
            return -1;
      }
      return -1; // if no splits are found
   }
}
