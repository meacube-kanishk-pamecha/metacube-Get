public class Operations {
 
    // If two Strings are equal return 1 else 0;
    protected int equals(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1!=n2) return 0;
        for(int i =0 ;i<n1;i++){
            if(s1.charAt(i)!=s2.charAt(i)) return 0;
        }
        return 1;

    }

    // return Reverse of a String 
    protected String reverse(String s1){
        char [] newStr= new char[s1.length()];
        int j =0;
        for(int i =s1.length()-1 ;i>=0;i--)
        {
            newStr[j++] = s1.charAt(i);
        }
        return new String(newStr);
    } 

    // chnages the Case of the String
    protected String caseChange(String str){
        char[] newStr = str.toCharArray();
        
        for(int i =0 ; i<str.length();i++)
        {
            if(str.charAt(i) >='a' && str.charAt(i)<='z')
            {
                newStr[i] = (char)(str.charAt(i)-32);
            }
            else if(str.charAt(i) >='A' && str.charAt(i)<='Z')
            {
                newStr[i] = (char)(str.charAt(i)+32);
            }
        }
        return new String(newStr);

    }

    // largest Word in the String
    protected String largestWord(String str){
     
        String[] sArray = str.split(" ");
        int Max = Integer.MIN_VALUE;
        String maxStr = "";
        for(int i =0 ;i <sArray.length ;i++)
        {
            if(sArray[i].length()>=Max){
                maxStr=sArray[i];
                Max = sArray[i].length();
            }
        }
    return maxStr;
    }
}
