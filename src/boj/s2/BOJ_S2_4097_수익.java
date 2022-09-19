package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 9. 19.
 * @see https://www.acmicpc.net/problem/4097
 * @performance 86844	572
 * @category #DP
 * @note
 */
public class BOJ_S2_4097_수익 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while(!(input = br.readLine()).equals("0")) {
            int T = Integer.parseInt(input);

            int max = Integer.MIN_VALUE;
            int[] arr = new int[T];
            for(int t=0;t<T;t++) {
                arr[t] = Integer.parseInt(br.readLine());

                if(arr[t] > max) max = arr[t];
            }

            int[] d = new int[T];

            d[0] = arr[0];

            for(int i=1;i<T;i++) {
                d[i] = Math.max(d[i-1] + arr[i], arr[i]);
                if(d[i] > max) max = d[i];
            }

            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}
