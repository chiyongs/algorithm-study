package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022.6.30
 * @see https://www.acmicpc.net/problem/2805
 * @performance 175288	708
 * @category #이분탐색
 * @note
 */
public class BOJ_S2_2805_나무자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int left = 0;
        int right = trees[N-1];
        int mid = 0;

        while(left <= right) {
            long sum = 0;
            mid = (left + right) / 2;
//            System.out.println("left: "+left+" mid: "+mid+" right: "+right);
            for(int i=0;i<N;i++) {
                if(trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }

            if(sum < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
//        System.out.println("left: "+left+" mid: "+mid+" right: "+right);
        System.out.println(right);
    }
}
