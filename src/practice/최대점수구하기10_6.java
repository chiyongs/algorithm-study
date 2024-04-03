package practice;

import java.util.Arrays;
import java.util.Scanner;

public class 최대점수구하기10_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] dp = new int[M+1];
        int[][] problems = new int[N][2];
        for(int i=0;i<N;i++) {
            problems[i][0] = sc.nextInt();
            problems[i][1] = sc.nextInt();
        }

        for(int i=0;i<N;i++) {
            for(int j=M;j>=problems[i][1];j--) {
                dp[j] = Math.max(dp[j],dp[j-problems[i][1]] + problems[i][0]);
            }
        }

        System.out.println(dp[M]);
    }
}
