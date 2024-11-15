package leetcode.recommendlist;

public class DecodeWays91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        if (s.charAt(0)-'0' == 0) {
            return 0;
        }
        dp[0] = 1;
        dp[1] = s.charAt(0) == 0 ? 0 : 1;

        for (int i=2;i<=s.length();i++) {
            int num = s.charAt(i-1) - '0';
            int prev = s.charAt(i-2) - '0';
            int sum = prev * 10 + num;

            if (num != 0) {
                dp[i] += dp[i-1];
            }
            if (10 <= sum && sum <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
