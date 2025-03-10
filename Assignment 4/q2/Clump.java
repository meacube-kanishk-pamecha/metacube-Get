package q2;

public class Clump {
    
    protected int noOfClumps(int [] arr)
    {
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
