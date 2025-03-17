package q1;

import java.util.HashMap;

public class Mirror {

    /**
     * 
     * maxMirror gives the max Number of mirror number present in the array
     * 
     * @param int [] arr length greater then 0
     * @return the maxMirror
     * @throws AssertionError if Array is Empty
     */
    // protected int maxMirror(int[] arr) throws AssertionError {
    //     if (arr.length == 0)
    //         throw new AssertionError("Empty Array");
    //     int max = Integer.MIN_VALUE;

    //     HashMap<String, Integer> s = new HashMap<>();
    //     for (int i = 0; i < arr.length; i++) {
    //         StringBuilder str = new StringBuilder();
    //         int count = 0;
    //         for (int j = i; j < arr.length; j++) {
    //             str.append(arr[j]); // Appending the sharacter
    //             count++;
    //             var ss = str.toString();   // Creating it a String
    //             s.put(ss, s.getOrDefault(ss, count)); // adding all the String Combinations
    //         }
    //     }
    //     for (var temp : s.keySet()) {
    //         StringBuilder strB = new StringBuilder(temp);
    //         String str = strB.reverse().toString(); // reversing the String
    //         if (s.containsKey(str)) { // if reverse is present then this will be followed
    //             max = Math.max(max, s.get(str));
    //         }

    //     }
    //     return max;
    // }

    protected int maxMirror(int []nums){
        int len = nums.length;int  count=0; int max=0;
        for(int i =0 ;i<len ;i++){
            count =0;
            for(int j =len-1 ;j>-1 && i+count<len;j--){
                if(nums[i+count]==nums[j]){
                    count++;
                }
                else {
                    if(count >0 ){
                        max=Math.max(count,max);
                        count =0;
                    }
                }
            }
            max = Math.max(count,max);
        }
        return max;
    }

}
