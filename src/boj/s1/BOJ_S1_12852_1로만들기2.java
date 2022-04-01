package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author chiyongs
 * @since 2022. 4. 1.
 * @see https://www.acmicpc.net/problem/12852
 * @performance 19488	108
 * @category #BFS #DP
 * @note
 */
public class BOJ_S1_12852_1로만들기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] d= new int[n+1];
		int[] prev = new int[n+1];
		d[1] = 0;
				
		for(int i=2;i<=n;i++) {
			d[i] = d[i-1] + 1;
			prev[i] = i-1;
			if(i%2==0) {
				if(d[i/2]+1<d[i]) {
					d[i] = d[i/2] + 1;
					prev[i] = i/2;
				}
			}
			if(i%3==0) {
				if(d[i/3]+1 < d[i]) {
					d[i] = d[i/3]+1;
					prev[i] = i/3;
				}
			}
			

		}
		System.out.println(d[n]);
		int cur = n;
		while(true) {
			System.out.print(cur+" ");
			if(cur == 1) break;
			cur = prev[cur];
		}
	}
	
}
