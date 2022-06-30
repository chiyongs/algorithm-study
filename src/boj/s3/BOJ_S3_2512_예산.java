package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022.6.30
 * @see https://www.acmicpc.net/problem/2512
 * @performance 13848	124
 * @category #이분탐색
 * @note
 */
public class BOJ_S3_2512_예산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] budgets = new int[N];
        for(int i=0;i<N;i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(budgets);

        int left = 1;
        int right = budgets[N-1];
        int mid = 0;

        while(left <= right) {
            mid = (left + right) / 2;

            long sum = 0;

            for(int i=0;i<N;i++) {
                if(budgets[i] > mid) {
                    sum += mid;
                } else {
                    sum += budgets[i];
                }
            }

            if(sum > M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}
