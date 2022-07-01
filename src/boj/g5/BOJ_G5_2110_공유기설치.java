package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 1.
 * @see https://www.acmicpc.net/problem/2110
 * @performance 28236	264
 * @category #이분탐색
 * @note
 */
public class BOJ_G5_2110_공유기설치 {

    static int N,C,homes[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        homes = new int[N];
        for(int i=0;i<N;i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);
        int left = 1;
        int right = homes[N-1] - homes[0];
        int mid = 0;

        while(left <= right) {
            mid = (left + right) / 2;

            int cnt = 1;
            int lastLocation = homes[0];
            for(int i=1;i<N;i++) {
                int location = homes[i];

                if(location - lastLocation >= mid) {
                    lastLocation = location;
                    cnt++;
                }
            }

            if(cnt >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);

    }
}
