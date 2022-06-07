package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 21.
 * @see https://www.acmicpc.net/problem/11501
 * @performance 320340	1040
 * @category #그리디
 * @note 
 * 		 
 */
public class BOJ_S2_11501_주식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int[] price = new int[N];
			for(int i=0;i<N;i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			long answer = 0;
			for(int i=N-1;i>=0;i--) {
				int cur = price[i];
				if(cur > max) max = cur;
				else {
					answer += max - cur;
				}
				
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);

	}

}
