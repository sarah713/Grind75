import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) {
            return list;
        }

        int m = s.length();
        int n = p.length();

        int[] count = freq(p);

        int[] currCnt = freq(s.substring(0, n));

        if (areSame(count, currCnt)) {
            list.add(0);
        }

        int i;
        for (i = n; i < m; i++) {
            currCnt[s.charAt(i - n) - 'a']--;
            currCnt[s.charAt(i) - 'a']++;
            if (areSame(count, currCnt)) {
                list.add(i - n + 1);
            }
        }
        return list;
    }

    private boolean areSame(int[] x, int[] y) {
        for (int i = 0; i < 26; i++) {
            if (x[i] != y[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] freq(String s) {
        int[] fre = new int[26];
        for (char c : s.toCharArray()) {
            fre[c - 'a']++;
        }
        return fre;
    }
}
