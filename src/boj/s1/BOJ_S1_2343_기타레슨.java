package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 1.
 * @see https://www.acmicpc.net/problem/2343
 * @performance 22632	268
 * @category #이분탐색
 * @note
 */
public class BOJ_S1_2343_기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long total = 0;
        st = new StringTokenizer(br.readLine(), " ");
        int[] lectures = new int[N];
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            total += lectures[i];
        }

        long left = 1;
        long right = total;
        long mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            System.out.println("left: " + left + " mid: " + mid + " right: " + right);
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (sum + lectures[i] > mid) {
                    cnt++;
                    if(lectures[i] > mid) {
                        cnt = Integer.MAX_VALUE;
                        break;
                    } else {
                        sum = lectures[i];
                    }
                    if (i == N - 1) cnt++;
                } else if (sum + lectures[i] == mid) {
                    cnt++;
                    sum = 0;
                } else {
                    sum += lectures[i];
                    if (i == N - 1) cnt++;
                }

            }

            System.out.println("---------");
            System.out.println("left: " + left + " mid: " + mid + " right: " + right);
            System.out.println("cnt: " + cnt);
            if (cnt <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            System.out.println("left: " + left + " mid: " + mid + " right: " + right);
        }

        System.out.println(left);
    }
}
