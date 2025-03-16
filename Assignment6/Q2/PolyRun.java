package Q2;

public class PolyRun {
    public static void main(String[] args) {
        Poly n1 = new Poly(new int[] { 1, 2, 3, 4 });
        Poly n2 = new Poly(new int[] { 1, 2, 3 });
        System.out.println(n1.Eval(2));
        n1.add(n1, n2).represents();
        n1.multiPoly(n1, n2).represents();
        
    } 
}
