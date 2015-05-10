import java.util.ArrayList;
import java.util.List;

public class SmallestSubstringContainingEnglsihAlphabet {
    private static List<Character> loadAlphabet() {
        List<Character> alphabetList = new ArrayList<>(26);
        for (char c = 'a'; c <= 'z'; c++)
            alphabetList.add(c);
        return alphabetList;
    }

    private static String findSubstring(String str) {
        boolean isValid = str.contains(" ") ? false : !str.matches("^\\p{ASCII}*$") ? false : true;
        String result = null;
        if (isValid) {
            List<Character> alphabetList = loadAlphabet();
            for (int i = 0; i < str.length(); i++) {
                List<Character> subString = new ArrayList<>();
                for (int j = i; j < str.length(); j++) {
                    subString.add(str.charAt(j));
                    if (subString.containsAll(alphabetList)) {
                        if (result == null || result.length() > subString.size())
                            result = str.substring(i, j + 1);
                        break;
                    }
                }
            }
        } else
            return "Invalid String";
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn"));
        System.out.println(findSubstring("aaaaaabcdefghijklmnopqrstuvwxyz"));
        System.out.println(findSubstring("aa1bcdefghijklmnopqrstuvwxyza2bcdefghijklmnopqrstuvwxyz"));
        System.out.println(findSubstring("abcde*&^%$#fkSlmnghij1234opqrtuvwxyz...abcdefghi1111111jklmnopqrstuv1wxyz"));
    }
}