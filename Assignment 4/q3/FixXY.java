package q3;

public class FixXY {
  
    /**
     * 
     * @param arr
     * @param int X the value of X on which the action is to be performed. 
     * @param int Y the value of Y which is to be behind the X
     * @return int []  on which the action is performed 
     * @throws AssertionError if Array is empty, two Consecutive X are present and
     *              if  Occurence of X and Y is not equal
     */
    protected  int[] arrayFixXY(int[] arr, int X, int Y) throws AssertionError {
     if(arr.length==0) throw new AssertionError("Empty Array");
        int xOccurence = 0;
        int yOccurence = 0;
        for (int i = 0; i < arr.length; i++) { 
            // Iterating throught the array for counting the number of x and y
            if (arr[i] == X)
                xOccurence++;
            if (arr[i] == Y)
                yOccurence++;
        }

        if (xOccurence != yOccurence) {
            // Occurence of X and Y is not equal
            throw new AssertionError("Unequal Number of X and Y");
        }
        if(arr[arr.length-1]==X){
            // At last Position the X is present
            throw new AssertionError("X is at last");
        }

        int yidx = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == X) {
                if(arr[i+1]==X) throw new AssertionError("Consecutive X Present");
                if (arr[i + 1] == Y) {
                    continue;
                } else {
                    while (yidx < arr.length && (arr[yidx] != Y || yidx > 0 && arr[yidx - 1] == X)) {
                        // Checks the next free y Value
                        yidx++;
                    }
                    if (yidx < arr.length) {
                        // Swaping the nuber behind x and with y
                        int temp = arr[yidx];
                        arr[yidx] = arr[i + 1];
                        arr[i + 1] = temp;
                    }

                }
            }
        }
        return arr;
    }
}
