package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_3079_입국심사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        int minTime = 0;
        int maxTime = 0;
        for(int n=0;n<N;n++) {
            times[n] = Integer.parseInt(br.readLine());
            minTime = Math.min(minTime, times[n]);
            maxTime = Math.max(maxTime, times[n]);
        }

        long left = minTime;
        long right = (long) maxTime * M;
        long mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;

            long cnt = 0;
            for(int n=0;n<N;n++) {
                cnt += mid/times[n];
            }

            if (cnt >= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
