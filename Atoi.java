public class Atoi {
    public int myAtoi(String s) {
        final int len = s.length();

        if (len == 0)
            return 0;

        int idx = 0;
        while (idx < len && s.charAt(idx) == ' ') {
            ++idx;
        }
        if (idx == 0)
            return 0;
        char sign = s.charAt(idx) == '+' ? '+' : '-';
        boolean isNegative = (sign == '-') ? true : false;

        if (isNegative || sign == '+') {
            ++idx;
        }

        int maxLimit = Integer.MAX_VALUE / 10;

        int result = 0;
        char c;
        while (idx < len && isDigit(c = s.charAt(idx))) {
            int digit = c - '0';
            if (result > maxLimit || (result == maxLimit && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = (result * 10) + digit;
            ++idx;
        }
        return isNegative ? -result : result;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
