package practice;

import java.util.Scanner;

public class 조합의경우수8_7 {

    static long[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        memo = new long[n+1][r+1];
        System.out.println(comb(n, r));
    }

    static long comb(int n, int r) {
        if (memo[n][r] > 0) return memo[n][r];
        if (n==r || r == 0) return memo[n][r] = 1;
        if (r == 1) return memo[n][r] = n;
        return memo[n][r] = comb(n-1, r-1) + comb(n-1, r);
    }
}
