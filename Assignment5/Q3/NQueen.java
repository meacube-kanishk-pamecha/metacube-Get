package Q3;

public class NQueen {
    
    public static void main(String[] args) {
        System.out.println(" we are in N queen Problem");
        int [][] arr = new int[4][4];
       System.out.println( nQueen(arr, 0));
        for (int[] is : arr) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }

    }

    protected static boolean nQueen(int[][] arr ,int row )
    {
        if(row==arr.length) return true;
        for (int j2 = 0; j2 < arr.length; j2++) {
            
                if( queenPresent(arr, row,j2 )){
                arr[row][j2] =1;
                if(nQueen(arr, row+1)) return true;
                arr[row][j2]=0;
               }
            
        }
   return true;
    }
    protected static boolean queenPresent(int [][]arr, int i, int j)
    {
        boolean safe = true;
        for(int k =0;k<arr.length;k++)
        {

            if(arr[i][k]!=0) safe = false; 

        }
        for(int k =0;k<arr.length;k++)
        {
            if(arr[k][j]!=0) safe = false;
        }
        int k =i;
        int l =j;
        while(k>=0 && l>=0){
            if(arr[k--][l--]!=0) safe =false;
        }
        k =i;
        l =j;
        while(k>=0&&l<arr.length)
        {
            if(arr[k--][l++]!=0) safe =false;
        }
        k =i;
        l =j;
        while(k<arr.length && l>=0)
        {
            if(arr[k++][l--]!=0) safe =false;
        }
        k =i;
        l =j;
        while(k<arr.length && l<arr.length)
        {
            if(arr[k++][l++]!=0) safe =false;
        }

      
       return safe;

    }
}
