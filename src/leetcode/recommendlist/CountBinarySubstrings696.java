package leetcode.recommendlist;

public class CountBinarySubstrings696 {
    public int countBinarySubstrings(String s) {
        int cur = 1;
        int prev = 0;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                result += Math.min(cur, prev);
                prev = cur;
                cur = 1;
            }
        }
        return result + Math.min(cur, prev);
    }
}
