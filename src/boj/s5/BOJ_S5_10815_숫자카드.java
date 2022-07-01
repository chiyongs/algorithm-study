package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 1.
 * @see https://www.acmicpc.net/problem/2512
 * @performance 140992	1072
 * @category #이분탐색
 * @note
 */
public class BOJ_S5_10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] nums = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++) {
            int x = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = N-1;
            int mid = 0;
            boolean flag = false;
            while(left <= right) {
                mid = (left + right) / 2;

                if(nums[mid] < x) {
                    left = mid + 1;
                } else if(nums[mid] > x) {
                    right = mid - 1;
                } else {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
