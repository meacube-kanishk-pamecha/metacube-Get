
class Marksheet {

    // average of number in a array
    protected double average(int[] arr) {
        double avg = 0;
        for (int j = 0; j < arr.length; j++) {
            avg += arr[j];
        }
        return avg / arr.length;
    }

    // max of a number in the array
    protected int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }

    //min of the number in a array
    protected int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = Math.min(i, min);
        }
        return min;
    }

    // percentage of persons have passed
    protected double passed(int[] arr) {
        double passed = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 40)
                passed++;
        }
        return (passed / arr.length) * 100;
    }

}