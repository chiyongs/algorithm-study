package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 9. 23.
 * @see https://www.acmicpc.net/problem/2230
 * @performance 27996	296
 * @category #투 포인터
 * @note
 */
public class BOJ_G5_2230_수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1];
        for(int i=1;i<=N;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int left = 1;
        int right = 1;
        int answer = 2000000001;
        int diff = 0;
        while(left <= right && right <= N) {
            if (diff >= M) {
                answer = Math.min(diff, answer);

                if(left == right) {
                    right++;
                    if(right > N) break;
                    diff = nums[right] - nums[left];
                } else {
                    left++;
                    diff = nums[right] - nums[left];
                }
            } else {
                right++;
                if(right > N) break;
                diff = nums[right] - nums[left];
            }
        }

        System.out.println(answer);
    }
}
