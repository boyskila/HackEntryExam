import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class SmallestSubstringContainingEnglsihAlphabet {
 
    public static boolean validateString(String str) {
 
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i)) && !str.matches("^\\p{ASCII}*$")) {
                return false;
            }
        }
        return true;
    }
 
    public String findSubstring(String str) {
 
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<Character> alphabetList = new ArrayList<Character>();
 
        char[] inputedString = str.toLowerCase().toCharArray();
        int substringSize = inputedString.length + 1;
        String result = null;
 
        if (validateString(str)) {
 
            for (char letter : alphabet.toCharArray()) {
                alphabetList.add(letter);
            }
 
            for (int i = 0; i < inputedString.length; i++) {
 
                List<Character> subString = new ArrayList<Character>();
 
                for (int j = i; j < inputedString.length; j++) {
 
                    subString.add(inputedString[j]);
 
                    if (subString.containsAll(alphabetList)) {
 
                        if (substringSize > subString.size()) {
                            substringSize = subString.size();
                            result = str.substring(i, j + 1);
                            break;
                        }
                    }
                }
            }
 
        } else {
            return "Invalid String";
        }
        return result;
    }
 
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String str = "abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn";
        String str1 = "aaaaaabcdefghijklmnopqrstuvwxyz";
        // String str =
        // "aa1bcdefghijklmnopqrstuvwxyza2bcdefghijklmnopqrstuvwxyz";
        // String str =
        // "abcde*&^%$#fkSlmnghij1234opqrtuvwxyz...abcdefghi11111111111111111111111111jklmnopqrstuv111wxyz";
        SmallestSubstringContainingEnglsihAlphabet sm = new SmallestSubstringContainingEnglsihAlphabet();
        System.out.println(sm.findSubstring(str));
        System.out.println(sm.findSubstring(str1));
        System.out.println("The program was execfuted for: " + (System.currentTimeMillis() - start) + " milliseconds.");
 
    }
}