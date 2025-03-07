
class Marksheet {

    public double average(int[] arr) {
        double avg = 0;
        for (int j = 0; j < arr.length; j++) {
            avg += arr[j];
        }
        return avg / arr.length;
    }

    public int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }

    public int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = Math.min(i, min);
        }
        return min;
    }

    public double passed(int[] arr) {
        double passed = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 40)
                passed++;
        }
        return (passed / arr.length) * 100;
    }

}