package Q3;

public class NQueen {

    /**
     * nQueen places the queen of n*n board .
     * 
     * @param int n the size of the board
     * @return int[][] the board and the queens placed on it denoted by 1
     */
    protected int[][] nQueen(int n) {
        if(n==0) throw new AssertionError("N cannot be zero");
        int[][] arr = new int[n][n];
        nQueen(arr, 0);
        return arr;
    }

    /**
     * nQueen places the queen of n*n board
     * 
     * @param int [][]arr the array on which queen is placed
     * @param int row the row on which the currently we are holding
     * @return boolean true if correct if false do not proceed
     */
    protected boolean nQueen(int[][] arr, int row) {
        if (row == arr.length)
            return true;
        for (int j2 = 0; j2 < arr.length; j2++) {
            if (queenPresent(arr, row, j2)) { // if it is safe to put proceed
                arr[row][j2] = 1; // put the queen here
                if (nQueen(arr, row + 1)) // shift to the next row
                    return true; // if correct return true
                arr[row][j2] = 0; // remove the queen
            }

        }
        return false;
    }

    /**
     * queenPresent if any other queen is present in the moving area of queen return
     * false.
     * 
     * @param int [][] arr on which operations are present
     * @param int i row of the current position
     * @param int j column of the current position
     * @return boolean
     */
    protected boolean queenPresent(int[][] arr, int i, int j) {
        boolean safe = true;
        // Checks in the column
        for (int k = 0; k < arr.length; k++) {
            if (arr[i][k] != 0) // queen is present it is not safe
                safe = false;

        }
        // checks in the row
        for (int k = 0; k < arr.length; k++) {
            if (arr[k][j] != 0) // queen is present it is not safe
                safe = false;
        }
        int k = i;
        int l = j;

        // checks in the upper left side
        while (k >= 0 && l >= 0) {
            if (arr[k--][l--] != 0) // queen is present it is not safe
                safe = false;
        }
        k = i;
        l = j;
        // checks in the lower left side
        while (k >= 0 && l < arr.length) {
            if (arr[k--][l++] != 0) // queen is present it is not safe
                safe = false;
        }
        k = i;
        l = j;
        // checks in the upper right side
        while (k < arr.length && l >= 0) {
            if (arr[k++][l--] != 0) // queen is present it is not safe
                safe = false;
        }
        k = i;
        l = j;
        // checks int lower right side
        while (k < arr.length && l < arr.length) {
            if (arr[k++][l++] != 0) // queen is present it is not safe
                safe = false;
        }

        return safe;

    }
}
