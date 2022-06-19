package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 19.
 * @see https://www.acmicpc.net/problem/15655
 * @performance 11532	76
 * @category #백트래킹 #순열
 * @note
 */
public class BOJ_S3_15655_N과M6 {

    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] input, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        input = new int[N];
        for(int i=0;i<N;i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        num = new int[M];

        Arrays.sort(input);

        comb(0,0);

        System.out.println(sb.toString());
    }

    static void comb(int cnt, int start) {
        if(cnt == M) {
            for(int i=0;i<M;i++) {
                sb.append(num[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++) {
            num[cnt] = input[i];
            comb(cnt+1, i+1);
        }
    }
}
