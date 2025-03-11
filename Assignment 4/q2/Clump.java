package q2;

public class Clump {
    
    /**
     * a series of 2 or more adjacent elements
     * @param int [] arr 
     * @return int the noOfClumps in the array 
     * @throws AssertionError if array is empty throw assertion error.
     */
    protected int noOfClumps(int [] arr) throws AssertionError
    { if(arr.length==0) throw new AssertionError("Empty Array");
        int count =0;
        int num =arr[0];
        int ansCount =0;
        for (int i = 1;i < arr.length; i++) {
            if(num==arr[i]) { count++;if(count==1) ansCount++;}
            else{
                count=0;
                num=arr[i];
            }
        }
        return ansCount;
    }
}
