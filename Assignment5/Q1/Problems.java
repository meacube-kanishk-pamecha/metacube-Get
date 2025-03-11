package Q1;

public class Problems {
    
    protected int  HCF(int x, int y)
    {
         if(x%y==0) return y;
       return HCF(y,x%y);       
    }

    protected int  LCM(int x, int y){
        if(y==0) return x;
        return x*y/LCM(x, y);
    }

}
