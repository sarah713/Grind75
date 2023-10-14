public class LPS {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String even = palin(s, i, i + 1);
            String odd = palin(s, i, i);

            if (even.length() > longest.length()) {
                longest = even;
            } else if (odd.length() > longest.length()) {
                longest = odd;
            }
        }
        return longest;
    }

    public String palin(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
