package boj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 31
 * @see https://www.acmicpc.net/problem/1037
 * @performance 11600	84
 * @category #수학
 * @note
 */
public class BOJ_B1_1037_약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[cnt];
        for(int i=0;i<cnt;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(((long) arr[0] * arr[cnt-1]));
    }
}
