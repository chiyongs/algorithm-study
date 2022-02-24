package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 24.
 * @see https://www.acmicpc.net/problem/7576
 * @performance 191488	752
 * @category #BFS
 * @note
 */

public class BOJ_G5_7576_토마토 {

	static int N, M, box[][], MIN;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		List<Integer[]> tomato = new ArrayList<>();
		MIN = Integer.MAX_VALUE;
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					tomato.add(new Integer[] { i, j });
				}
			}
		}
		int[][] days = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				days[r][c] = -1;
			}
		}
		Queue<Integer[]> Q = new LinkedList<>();
		for (int i = 0, size = tomato.size(); i < size; i++) {
			int startR = tomato.get(i)[0];
			int startC = tomato.get(i)[1];
			Q.offer(new Integer[] { startR, startC, 0 });
			days[startR][startC] = 0;
		}

		while (!Q.isEmpty()) {
			Integer[] cur = Q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (days[nr][nc] != -1 || box[nr][nc] != 0)
					continue;
				if (box[nr][nc] == 0) {
					days[nr][nc] = cur[2] + 1;
					Q.offer(new Integer[] { nr, nc, cur[2] + 1 });
				}
			}
		}
		int max = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (days[r][c] == -1 && box[r][c] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(days[r][c], max);
			}
		}

		if (max < MIN) {
			MIN = max;
		}

		System.out.println(MIN);

	}

}
