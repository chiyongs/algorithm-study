package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 28.
 * @see https://www.acmicpc.net/problem/1654
 * @performance 15388	144
 * @category #이분탐색
 * @note
 */
public class BOJ_S2_1654_랜선자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];
        for(int i=0;i<K;i++) {
            int x = Integer.parseInt(br.readLine());
            lines[i] = x;
        }

        Arrays.sort(lines);

        long left = 1;
        long right = lines[K-1];
        long mid = 0;

        while(left <= right) {
            mid = (left + right) / 2;

            long count = 0;
            for(int i=0;i<K;i++) {
                count += lines[i] / mid;
            }

            if(count < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);

    }
}
