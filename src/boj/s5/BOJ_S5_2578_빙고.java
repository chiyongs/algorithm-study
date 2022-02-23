package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 23.
 * @see https://www.acmicpc.net/problem/2578
 * @performance 11548	80
 * @category #구현
 * @note
 */

public class BOJ_S5_2578_빙고 {

	static int[][] me;
	static boolean[][] bingo;
	static int bingoCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		me = new int[5][5];
		int[][] so = new int[5][5];
		bingo = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				me[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				so[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int numCnt = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int num = so[i][j];
				find(num);
				numCnt++;
				if (isBingo()) {
					System.out.println(numCnt);
					return;
				}
			}
		}
	}

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

	private static boolean isBingo() {
		int cnt = 0;
		for (int r = 0; r < 5; r++) {
			boolean y = true;
			for (int c = 0; c < 5; c++) {
				if (me[r][c] == 0) {
					y &= true;
				} else {
					y &= false;
				}
			}
			if (y) {
				cnt++;
			}
			if (cnt == 3) {
				return true;
			}
		}

		for (int r = 0; r < 5; r++) {
			boolean y = true;
			for (int c = 0; c < 5; c++) {
				if (me[c][r] == 0) {
					y &= true;
				} else {
					y &= false;
				}
			}
			if (y) {
				cnt++;
			}
			if (cnt == 3) {
				return true;
			}
		}
		boolean y = true;
		for (int r = 0; r < 5; r++) {

			if (me[r][r] == 0) {
				y &= true;
			} else {
				y &= false;
			}
		}

		if (y) {
			cnt++;
		}
		if (cnt == 3) {
			return true;
		}

		y = true;
		for (int r = 0; r < 5; r++) {
			if (me[r][5 - 1 - r] == 0) {
				y &= true;
			} else {
				y &= false;
			}
		}

		if (y) {
			cnt++;
		}
		if (cnt == 3) {
			return true;
		}

		return false;
	}

	private static void find(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (me[i][j] == num) {
					me[i][j] = 0;
					return;
				}
			}
		}
	}
}
