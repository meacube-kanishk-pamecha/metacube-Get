package Q2;

public class Search {
    /**
     * 
     * @param arr
     * @param x
     * @param idx
     * @return
     */
    public int binary(int [] arr, int x,int idx)
    { if(idx>arr.length-1||idx<0) return -1;
        if(arr[idx]==x) return idx;
       int a =  binary(arr,x,0+idx/2);
       int b =  binary(arr, x, (idx+arr.length)/2);
        if(a==-1 && b==-1) return -1;
        if(a==-1)return b;
        return a;
    }
    /**
     * 
     * @param arr
     * @param idx
     * @param x
     * @return
     */
    protected int linear(int []arr,int idx,int x)
    {
        if(arr[idx]==x) return idx;
        if(idx<0) return -1;
       return linear(arr, idx-1,x);
    }
}
