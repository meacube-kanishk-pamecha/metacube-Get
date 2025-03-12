package Q2;

public class Search {
   
    /**
     * binary Uses binary search to search in the array
     * 
     * @param int []arr Array in which the Number is to be searched 
     * @param int x Number that is to be searched in the array
     * @return int index of that Number 
     * @throws AssertionError if array is empty
     */
    public int binary(int[]arr,int x) throws AssertionError
    {
        if(arr.length==0)  throw new AssertionError("Invalid Input");
        return binaryFunc(arr, x, 0,arr.length);

    }
    /**
     * binaryFunc Uses binary search to search in the array
     * 
     * @param int []arr Array in which the Number is to be searched 
     * @param int x Number that is to be searched in the array
     * @param l  left index in which we are searching
     * @param r  right most index of the array
     * @return int index of that Number
     */
    public int binaryFunc(int [] arr, int x,int l,int r)
    { if(r>=l && l<=arr.length-1) 
      {  int idx = l+(r-l)/2;
        if(arr[idx]==x) return idx;
       if(arr[idx]> x) return binaryFunc(arr,x,l ,idx-1);
        else return binaryFunc(arr, x, idx+1,r);
      }
      return -1;
    }
    /** linearFunc Uses linear search to search in the array
    * 
    * @param int []arr Array in which the Number is to be searched 
    * @param int idx   index on which we are searching
    * @param int num Number that is to be searched in the array
    * @return int index of that Number
    */
    protected int linearFunc(int []arr,int idx,int num)
    {
        if(arr[idx]==num) return idx;
        if(idx>arr.length-1) return -1;
       return linearFunc(arr, idx+1,num);
    }
     /** linearFunc Uses linear search to search in the array
    * 
    * @param int []arr Array in which the Number is to be searched 
    * @param int idx   index on which we are searching
    * @param int num Number that is to be searched in the array
    * @return int index of that Number
    * @throws AssertionError if array is empty
    */
    protected int linear(int[]arr,int num) throws AssertionError
    {
        if(arr.length==0)  throw new AssertionError("Invalid Input");
        return linearFunc(arr, 0,num);
    }
}
