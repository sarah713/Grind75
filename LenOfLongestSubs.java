import java.util.HashSet;

public class LenOfLongestSubs {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int maxlen = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
            }
            maxlen = Math.max(maxlen, j - i);
        }
        return maxlen;
    }
}
