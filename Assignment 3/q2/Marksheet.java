
class Marksheet {

    /**
     * average calculates the average of the given array
     * 
     * @param arr the marks as the input in the array
     * @return float upto 2 decimal value
     * @throws ArithmeticException if height or base is zero
     */
    protected String average(int[] arr) throws ArithmeticException{
        // average of number in a array
        if(arr.length==0) throw new ArithmeticException("Exception in average Calculation");
        float avg = 0;
        for (int j = 0; j < arr.length; j++) { // Iterating the array & adding to avg.
            avg += arr[j];
        }
        return String.format("%.2f", (avg / arr.length)); // returning the .2f variable

    }

    /**
     * max to find the max value in the array
     * 
     * @param arr the marks as the input in the array
     * @return int return the max marks
     * @throws ArithmeticException if height or base is zero
     */
    protected int max(int[] arr) throws ArithmeticException {
        // max of a number in the array
        if(arr.length==0) throw new ArithmeticException("Exception in max");
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max); // iterating the
        }
        return max;
    }

    /**
     * min to find the min value in the array
     * 
     * @param arr the marks as the input in the array
     * @return int return the min marks from the array
     * @throws ArithmeticException if height or base is zero
     */
    protected int min(int[] arr) throws ArithmeticException {
        // min of the number in a array
        if(arr.length==0) throw new ArithmeticException("Exception in min");
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = Math.min(i, min);
        }
        return min;
    }

    /**
     * passed checks how many students are passed
     * 
     * @param arr the marks as the input in the array
     * @return float the percentage of the students that are passed
     * @throws ArithmeticException if height or base is zero
     * 
     */
    protected String passed(int[] arr) throws ArithmeticException {
        if(arr.length==0) throw new ArithmeticException("Exception in passed  percentage");
        float passed = 0;
        for (int i = 0; i < arr.length; i++) { // iterating through the array incrementing the count if passed
            if (arr[i] >= 40)
                passed++;
        }
        return String.format("%.2f", (passed / arr.length) * 100); // returning .2f

    }

}