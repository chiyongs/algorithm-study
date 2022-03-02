package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 28.
 * @see https://www.acmicpc.net/problem/1629
 * @performance 11548 88
 * @category #재귀
 * @note
 */
public class BOJ_S1_1629_곱셈 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());

		System.out.println(calc(A, B, C));
	}

	private static long calc(long a, long b, long c) {
		if (b == 1) {
			return a % c;
		}
		long val = calc(a, b / 2, c);
		val = val * val % c;

		if (b % 2 == 0) {
			return val;
		} else {
			return val * a % c;
		}
	}

}
