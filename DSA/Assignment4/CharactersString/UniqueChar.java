package CharactersString;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueChar {
    static HashMap<String, Integer> stringChars = new HashMap<>();

    /**
     * countUniqueChar take a string and results the unique character in the string
     * 
     * @param String s the string in which unique charater are to be counted
     * @return int return the unique
     */
    public static int countUniqueChar(String s) {
        if (stringChars.containsKey(s))
            return stringChars.get(s);
        else {
            System.out.println("sjshdiushd");
            int a = 0;
            char[] c = s.toCharArray();
            HashSet<Character> charmemory = new HashSet<>();
            // checkin that character is present in hashset or not
            for (char character : c) {
                charmemory.add(character);
            }
            a = charmemory.size();
            stringChars.put(s, a);
            return a;
        }

    }

    public static void main(String[] args) {
        System.out.println("Number of unique character");
        String a = "cslkjkja";
        String b = "cslkjkja";
        System.out.println(countUniqueChar(a));
        System.out.println(countUniqueChar(b));
    }

}
