package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 5. 28.
 * @see https://www.acmicpc.net/problem/1458
 * @performance 11556	76
 * @category #그리디
 * @note
 */
public class BOJ_S5_1459_걷기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		boolean straightFast = false;
		if (2 * W <= S)
			straightFast = true;

		long answer = 0;
		if (straightFast) {
			answer = (X + Y) * W;
		} else {
			long min = Math.min(X, Y);
			answer += min * S;

			long max = Math.max(X, Y);
			if (W > S) {
				answer += (max - min) * S;
				if ((max - min) % 2 != 0) {
					answer += W - S;
				}
			} else {
				answer += (max - min) * W; 
			}
		}

		System.out.println(answer);
	}
}
