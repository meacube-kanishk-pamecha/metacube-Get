 package Q1;

 public class intSetClass {
    
      public static void main(String[] args) {
        System.out.println("We are in intset");
        intSet sc = new intSet(new int[]{10,20,40});
        intSet s = sc.getComplement();
       System.out.println( sc.isMember(10));
System.out.println(sc.size());
System.out.println(sc.isSubSet(sc));
System.out.println(s.isMember(100));
    }
}