package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 2. 28.
 * @see https://www.acmicpc.net/problem/11729
 * @performance 44808	316
 * @category #재귀
 * @note
 */
public class BOJ_S1_11729_하노이탑이동순서 {
	
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(1,3,N);
		System.out.println(cnt);
		System.out.println(sb.toString());		
	}
	
	private static void hanoi(int from, int to, int n) {
		if(n==1) {
			cnt++;
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		
		hanoi(from, 6-from-to, n-1);
		sb.append(from).append(" ").append(to).append("\n");
		cnt++;
		hanoi(6-from-to,to,n-1);
	}
}
