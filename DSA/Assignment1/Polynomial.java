import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Polynomial {
    
    
    public static void main(String[] args) {
        List<polyno> newList = new ArrayList<>();
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the nu in term ");
        int n = Sc.nextInt();
        // taking the input from the end user
        for(int i =0;i<n;i++)
        {
            List<Poly> ans = new ArrayList<>();
            System.out.println("Eneter the coeff");
            int a = Sc.nextInt();
            System.out.println("number of Variable");
            int k = Sc.nextInt();
            // taking the variables in list and their powers
            for(int j =0;j<k;j++){
                System.out.println("Eneter the Variable");
                char newchar = Sc.next().charAt(0);
                System.out.println("Power of variable");
                int pow = Sc.nextInt();
                Poly poly = new Poly(newchar, pow);
                ans.add(poly);
            }
            polyno pn = new polyno(a, ans);
            newList.add(pn);

        }
        System.out.println(newList);
        System.out.println(degree(newList));
        Sc.close();
    }
  public static int degree( List<polyno> newList ){
    int max =0;
    for (polyno polyno : newList) {
        int deg =0;
        for (Poly pol : polyno.ans) {   
            deg+=pol.x;
        }
        max =Math.max(max, deg);
    }
    return max;
  }
}

// poly class to store the variables and their power
class Poly{
    char c;
    int x;
    Poly(char c, int x ){
        this.c =c;
        this.x =x;
    }
    @Override
    public String toString() {
        return "" + c + "^" + x + " ";
    }

}
// to store coff and its variables or the list of variables
class polyno{
    int coeff;
    List<Poly> ans = new ArrayList<>();
  polyno(int coeff, List<Poly> ans){
    this.coeff=coeff;  
    this.ans = ans;
  }
  @Override
  public String toString() {
    return " + " + coeff + "" + ans + "";
  }

}
