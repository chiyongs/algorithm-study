package practice;

import java.util.Scanner;

public class 최대점수구하기8_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][2];
        int[] dp = new int[M+1];
        for(int i=0;i<N;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for(int i=0;i<N;i++) {
            for(int j=M;j>=arr[i][1];j--) {
                dp[j] = Math.max(dp[j],dp[j-arr[i][1]]+ arr[i][0]);
            }
        }

        System.out.println(dp[M]);
    }
}
