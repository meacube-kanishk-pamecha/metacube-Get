package Q1;

final class intSet {
    private boolean[] arr = new boolean[1001];
    private int num = 0;

    /**
     * Constructor of intset class if the input is integer array
     * 
     * @param int [] array
     */
    intSet(int[] array) {
        // 
        for (int i = 0; i < array.length; i++) {
            arr[array[i]] = true;
        }
    }

     
    /**
     * Constructor of intset class if the input is boolean array
     * 
     * @param boolean [] array
     */
    intSet(boolean[] array) {
        arr = array;
    }

    /**
     * isMember return that this integer is member of this
     * 
     * @param int i the input which is to be checked that it is in the Set
     * @return boolean if it finds the number return true else false
     */
    public boolean isMember(int i) {
        //
        if (arr[i] == true)
            return true;
        return false;
    }

    /**
     * size return the size of the set
     * 
     * @return int num of elements of the set
     */
    public int size() {
        for (boolean a : arr) {
            if (a)
                num++;
        }
        return num;

    }

    /**
     * isSubSet checks the given set is a subset of the current set.
     * 
     * @param intSet st which is to be checked as the subset of the current class
     * @return boolean if it is the subset then return true else return false
     */

    public boolean isSubSet(intSet st) {
        for (int i = 0; i < 1001; i++) {
            if (!st.arr[i] && this.arr[i])
                return false;
        }
        return true;
    }

    /**
     * getComplement return a new set which is the complement of the current object
     * 
     * @return intSet which is a new set and it is the complement of the current set
     */
    public intSet getComplement() {
        boolean[] newarr = new boolean[this.arr.length];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = !arr[i];
        }
        return new intSet(newarr);
    }

    /**
     * union it gives the union of the current set and set passed to it
     * 
     * @param intSet st the with wich we have to do union in it
     * @return intSet return an object of intSet wich is union of both the set
     */
    public intSet union(intSet st) {
        boolean[] newarr = new boolean[this.arr.length];
        // looping through all the number
        for (int i = 0; i < arr.length; i++) {
            // checking if it is present in any of the set
            if (st.arr[i] || this.arr[i])
                newarr[i] = true;
        }
        return new intSet(newarr);
    }

    /**
     * intersection gives the intersection of the two sets
     * 
     * @param intSet st it is an object of the intSet with the elements
     * @return a intSet new intSet for intersection of the two set 
     */
    public intSet intersection(intSet st) {
        boolean[] newarr = new boolean[this.arr.length];
        // looping through all the numbers
        for (int i = 0; i < arr.length; i++) {
            // checking it is present in both the set or not
            if (st.arr[i] && this.arr[i])
                newarr[i] = true;
        }
        return new intSet(newarr);
    }

}
