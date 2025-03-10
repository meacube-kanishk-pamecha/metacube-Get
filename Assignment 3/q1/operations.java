public class Operations {

    /**
     * equals To see If two Strings are equal
     * 
     * @param Strings s1  One of the String
     * @param Strings s2  Other String to be compared with s1.
     * @return int  If equals then return 1 else return 0;
     * 
     */
    protected int equals(String s1, String s2) {
        // Checking two Strings are equal or not
        int n1 = s1.length();
        int n2 = s2.length(); // lengths of the string
        if (n1 != n2)
            return 0; // Strings are not of equal length
        for (int i = 0; i < n1; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return 0; // String is not equal returning 0
        }
        return 1; // String is equal return 1

    }

    /**
     * reverse the method rverses the given String
     * 
     * @param String s1 String Which is to be reversed
     * @return String the reversed String
     * 
     */
    protected String reverse(String s1) {
        // Reverse of a String
        char[] newStr = new char[s1.length()]; // Creating an Array type char of length of the String
        int j = 0;
        for (int i = s1.length() - 1; i >= 0; i--) // loop from end to start of the string
        {
            newStr[j++] = s1.charAt(i);
        }
        return new String(newStr); // returning the reversed String
    }

    /**
     * caseChange Changes the case of the String.
     * 
     * @param String str : On which case Changing is to be done
     * @return String : the same string but with the changed case
     */
    protected String caseChange(String str) {
        // chnages the Case of the String
        char[] newStr = str.toCharArray(); // string to char Array

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') // check's for the smaller case letters
            {
                newStr[i] = (char) (str.charAt(i) - 32); // lower to upper case
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') // checks for the Upper case letters
            {
                newStr[i] = (char) (str.charAt(i) + 32); // upper to lower case
            }
        }
        return new String(newStr); // returns the char Array in the String format

    }

    /**
     * largestWord return the largest Word
     * 
     * @param String str words of different length
     * @return String word with the max length in the string 
     */
    protected String largestWord(String str) {
        // largest Word in the String

        String[] sArray = str.split(" "); // Splits the Stirng on the basis of space and storing it in array
        int Max = Integer.MIN_VALUE;
        String maxStr = ""; // for storing the maxString
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].length() >= Max) {// comparing the String with the max String
                maxStr = sArray[i];   
                Max = sArray[i].length(); 
            }
        }
        return maxStr; // returning the maximum string present
    } 
}
