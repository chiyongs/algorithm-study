package leetcode.recommendlist;

public class StringToInteger8 {
    public int myAtoi(String s) {
        if ("".equals(s)) {
            return 0;
        }

        int idx = 0, res = 0;
        int sign = 1;

        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }

        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            if (s.charAt(idx++) == '-') {
                sign = -1;
            }
        }

        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }

            res = res * 10 + (s.charAt(idx++) - '0');
        }
        return sign * res;
    }
}
