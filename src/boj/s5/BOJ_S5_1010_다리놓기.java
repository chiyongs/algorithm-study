package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 10. 10.
 * @see https://www.acmicpc.net/problem/101-
 * @performance 11848	80
 * @category #DP #수학
 * @note
 */
public class BOJ_S5_1010_다리놓기 {

    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(comb(M, N)).append("\n");
        }

        System.out.println(sb);
    }

    static int comb(int M, int N) {

        if(dp[M][N] > 0) return dp[M][N];
        if(M==N || N == 0) return dp[M][N] = 1;

        return dp[M][N] = comb(M-1,N-1) + comb(M-1,N);

    }

}
