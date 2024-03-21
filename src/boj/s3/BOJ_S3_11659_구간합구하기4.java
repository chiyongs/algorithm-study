package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2024. 3. 21.
 * @see https://www.acmicpc.net/problem/11659
 * @performance 64500	720
 * @category #dp
 * @note
 */
public class BOJ_S3_11659_구간합구하기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dy = new int[N+1];
        for (int i=1;i<=N;i++) {
            dy[i] = dy[i-1] + arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(dy[to]-dy[from-1]).append("\n");
        }
        System.out.print(sb);
    }
}
