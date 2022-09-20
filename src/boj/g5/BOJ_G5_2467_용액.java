package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 9. 20.
 * @see https://www.acmicpc.net/problem/2467
 * @performance 31912	272
 * @category #투 포인터
 * @note
 */
public class BOJ_G5_2467_용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;

        int answer = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        while(left < right) {

            int result = arr[left] + arr[right];
            if(answer > Math.abs(result)) {
                answer = Math.abs(result);
                x = arr[left];
                y = arr[right];
            }

            if(result < 0) {
                left++;
            } else if(result > 0) {
                right--;
            } else {
                System.out.println(arr[left]+ " " + arr[right]);
                return;
            }
        }

        System.out.println(x+" "+y);
    }
}
