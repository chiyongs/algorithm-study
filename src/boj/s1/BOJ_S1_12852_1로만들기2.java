package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author chiyongs
 * @since 2024. 3. 21.
 * @see https://www.acmicpc.net/problem/12852
 * @performance 39276	136
 * @category #BFS #DP
 * @note
 */
public class BOJ_S1_12852_1로만들기2 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] dy = new int[N+1][2];
		for (int i=2;i<=N;i++) {
			dy[i][0] = dy[i-1][0] + 1;
			dy[i][1] = i-1;
			if (i % 3 == 0) {
				int num = dy[i/3][0] + 1;
				if (num < dy[i][0]) {
					dy[i][0] = num;
					dy[i][1] = i/3;
				}
			}
			if (i % 2 == 0) {
				int num = dy[i/2][0] + 1;
				if (num < dy[i][0]) {
					dy[i][0] = num;
					dy[i][1] = i/2;
				}
			}
		}
		System.out.println(dy[N][0]);
		print(dy, N);
		System.out.println(sb);
	}

	public static void print(int[][] dy, int n) {
		if (n==1) {
			sb.append(n);
			return;
		}
		sb.append(n).append(" ");
		print(dy, dy[n][1]);
	}
	
}
