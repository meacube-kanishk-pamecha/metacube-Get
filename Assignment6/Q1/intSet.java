package Q1;
class intSet{
    boolean[]arr = new boolean[1000];
    private int num =0;

    intSet(int[]array){
        for (int i = 0; i < array.length; i++) {
            arr[array[i]]= true;
        }
    }
    public boolean isMember(int i){
        if(arr[i]==true) 
        return true;
        return false;
    }
    public int size(){
            for(boolean a :arr)
            {
                if(a) num++;
            }
            return num;

    }
   
    public boolean isSubSet(intSet st )
    {
        for(int i =0 ;i<1000;i++)
        {
            if(st.arr[i] && !this.arr[i])return false;
        }
        return true;
    }
    public boolean[] getComplement(){
        boolean [] newarr = new boolean[this.arr.length];
        for(int i =0;i<arr.length;i++){
            newarr[i]=!arr[i];
        }
        return newarr;
    }
    public boolean[] union(intSet st){
        boolean [] newarr = new boolean[this.arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(st.arr[i]||this.arr[i])  newarr[i]=true;
        }
        return newarr;
    }
    public boolean[] intersection(intSet st){
        boolean [] newarr = new boolean[this.arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(st.arr[i] && this.arr[i])  newarr[i]=true;
        }
        return newarr;
    }

}
