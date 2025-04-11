package Dictionary;

public class Test {
    public static void main(String[] args) {
        System.out.println("Dictionary");
        
        
        Tree t = new Tree("Zpple", "Fruit of hthe");
        t.add(t, new Tree("Aa", "kdsjdk"));
        t.add(t, new Tree("Zall", "Anything"));
       
        t.parseJSON("{ 'key':Konnng , 'value': another animal},\n" + "{'key':Elephant , 'value': bigger}");
        System.out.println(t.sorted(t));
        
        System.out.println(t.sortedBetween("B", "S", t));
       
        t.delete(t, "Aa");
        System.out.println(t.sorted(t));

    }

}
