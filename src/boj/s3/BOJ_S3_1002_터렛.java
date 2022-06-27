package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 27.
 * @see https://www.acmicpc.net/problem/1002
 * @performance 11872	92
 * @category #수학
 * @note
 */
public class BOJ_S3_1002_터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken()) + 10000;
            int y1 = Integer.parseInt(st.nextToken()) + 10000;
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) + 10000;
            int y2 = Integer.parseInt(st.nextToken()) + 10000;
            int r2 = Integer.parseInt(st.nextToken());

            double dist = Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2);

            if(x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            } else if(x1 == x2 && y1 == y2) {
                System.out.println(0);
            } else if(dist < Math.pow(Math.abs(r2-r1),2)) {
                System.out.println(0);
            } else if(dist == Math.pow(Math.abs(r2-r1),2)) {
                System.out.println(1);
            } else if(dist == Math.pow(Math.abs(r2+r1),2)) {
                System.out.println(1);
            } else if(dist < Math.pow(Math.abs(r2+r1),2)) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }

        }

    }
}
