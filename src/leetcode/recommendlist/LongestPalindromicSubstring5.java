package leetcode.recommendlist;

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        String result = "";

        for(int i=0;i<s.length();i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i+1);

            if (odd.length() > result.length()) {
                result = odd;
            }
            if (even.length() > result.length()) {
                result = even;
            }
        }

        return result;
    }

    private String expand(String s, int start, int end) {
        int left = start;
        int right = end;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left+1, right);
    }
}
