import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    public static final HashMap<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0 || digits == null) {
            return res;
        }
        helper(digits, 0, new StringBuilder(), res);
        return res;
    }

    public void helper(String digits, int idx, StringBuilder sb, List<String> res) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char digit = digits.charAt(idx);
        String letters = map.get(digit);

        for (char c : letters.toCharArray()) {
            sb.append(c);
            helper(digits, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
