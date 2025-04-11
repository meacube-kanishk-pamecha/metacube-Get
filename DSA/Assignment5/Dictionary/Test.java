package Dictionary;

public class Test {
    public static void main(String[] args) {
        System.out.println("Dictionary");
        
        // starting a tree structure and adding nodes
        Tree t = new Tree("Zpple", "Fruit of hthe");
        t.add(t, new Tree("Aa", "kdsjdk"));
        t.add(t, new Tree("Zall", "Anything"));
       
        // input using JSON String
        t.parseJSON("{ 'key':Konnng , 'value': another animal},\n" + "{'key':Elephant , 'value': bigger}");
        System.out.println(t.sorted(t));
        
        // Sorting the string with this keys
        System.out.println(t.sortedBetween("B", "S", t));
       
        // deleting a node if present
        t.delete(t, "Aa");
        System.out.println(t.sorted(t));

    }

}
