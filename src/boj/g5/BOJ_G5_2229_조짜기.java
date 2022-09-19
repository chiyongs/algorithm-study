package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 9. 19.
 * @see https://www.acmicpc.net/problem/2229
 * @performance 11996	116
 * @category #DP
 * @note
 */

public class BOJ_G5_2229_조짜기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N+1];
        for(int i=2;i<=N;i++) {
            int max = 0;
            int min = 10001;

            for(int j=i;j>0;j--) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);

                d[i] = Math.max(d[i], max-min+d[j-1]);
            }

        }

        System.out.println(d[N]);
    }
}
