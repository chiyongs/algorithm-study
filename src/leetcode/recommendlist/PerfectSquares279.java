package leetcode.recommendlist;

import java.util.Arrays;

public class PerfectSquares279 {
    public int numSquares(int n) {
        int size = (int) Math.sqrt(n);
        int[] perfectSquares = new int[size];
        for (int i=1;i<=size;i++) {
            perfectSquares[i-1] = i * i;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int perfectSquare : perfectSquares) {
            dp[perfectSquare] = 1;
            for (int i=perfectSquare+1;i<=n;i++) {
                dp[i] = Math.min(dp[i], dp[i-perfectSquare]+1);
            }
        }
        return dp[n];
    }
}
