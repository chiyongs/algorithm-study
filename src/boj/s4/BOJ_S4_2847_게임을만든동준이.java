package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 5. 23.
 * @see https://www.acmicpc.net/problem/2847
 * @performance 11488	76
 * @category #그리디
 * @note 
 * 		 
 */
public class BOJ_S4_2847_게임을만든동준이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		for(int i=N-1;i>=1;i--) {
			int cur = nums[i];
			int next = nums[i-1];
			if(cur > next) continue;
			else if(cur == next) {
				nums[i-1]--;
				answer++;
			} else {
				nums[i-1] = next - (next-cur+1);
				answer += (next-cur+1);
			}
			
		}
		System.out.println(answer);
	}

}
