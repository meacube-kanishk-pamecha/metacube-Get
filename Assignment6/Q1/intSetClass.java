package Q1;

public class intSetClass {

  public static void main(String[] args) {
    System.out.println("We are in intset");
    int [] newarr = new int[] { 10, 20, 40 };
    intSet sc = new intSet(newarr);
    intSet s = sc.getComplement();
    System.out.println(sc.isMember(10));
    System.out.println(sc.size());
    System.out.println(sc.isSubSet(sc));
    System.out.println(s.isMember(100));
  }
}