package practice;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환10_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }
        int M = sc.nextInt();

        int[] dp = new int[M+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=M;i++) {
            for(int j=0;j<N;j++) {
                if (i - arr[j] > 0) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]]+1);
                } else if (i - arr[j] == 0) {
                    dp[i] = Math.min(dp[i], 1);
                } else {
                    dp[i] = Math.min(dp[i], Integer.MAX_VALUE);
                }
            }
        }

        System.out.println(dp[M]);
    }
}
