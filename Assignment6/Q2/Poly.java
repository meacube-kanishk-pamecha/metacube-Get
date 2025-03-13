package Q2;

import java.util.Arrays;

public class Poly{
    int []coeff;
    Poly(int []arr){
     coeff = Arrays.copyOf(arr,arr.length) ;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Arrays.toString(coeff);
    }
    float Eval(float x)
    {
        float ans =0;
        float pow=1;
        for(int i :coeff)
        {
            ans+= i*pow;
            pow*=x;
        }
        return ans;

    }

    int max(Poly p1, Poly p2)
    
    {
        return(Math.max(p1.coeff.length,p2.coeff.length ));
    }
     Poly add(Poly p1 , Poly p2)
    {
        int max = max(p1,p2);
        int rem =0;
        int []  newarr= new int[max+1];
        for (int i = 0; i < max; i++) {
            newarr[i]=(p1.coeff[i]+p2.coeff[i]+rem)%10;
            rem = (p1.coeff[i]+p2.coeff[i])/10;
        }
        return new Poly(newarr);
    }
    Poly multiPoly(Poly p1, Poly p2)
    {
        int max = max(p1,p2);
        int rem =0;
        int []  newarr= new int[max+1];
        for (int i = 0; i < max+1; i++) {
            if(i==max) newarr[i]=rem;
           else{ newarr[i]=((p1.coeff[i]*p2.coeff[i])+rem)%10;
            rem = ((p1.coeff[i]*p2.coeff[i])+rem)/10;
           }
        }
        return new Poly(newarr);
    }


    public static void main(String[] args) {
        Poly n1 = new Poly(new int[]{1,2,3,4});
        Poly n2 = new Poly(new int[]{1,2,3,4});
        System.out.println(n1.Eval(2));
        System.out.println(n1.add(n1, n2));
        System.out.println(n1.multiPoly(n1, n2));
    }
}