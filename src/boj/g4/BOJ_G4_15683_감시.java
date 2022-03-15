package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 15.
 * @see https://www.acmicpc.net/problem/15683
 * @performance 21136	372
 * @category #구현
 * @note 
 * 		 
 */
public class BOJ_G4_15683_감시 {

	static class CCTV {
		int no, r, c;

		public CCTV(int no, int r, int c) {
			this.no = no;
			this.r = r;
			this.c = c;
		}

	}

	static int[][] office;
	static int[][] map;
	static int N, M, min;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		office = new int[N][M];
		map = new int[N][M];

		List<CCTV> cctvs = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(st.nextToken());
				office[i][j] = val;
				if (val == 0)
					min++;
				if (val != 0 && val != 6) {
					cctvs.add(new CCTV(val, i, j));
				}
			}
		}

		for (int temp = 0; temp < Math.pow(4, cctvs.size()); temp++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = office[i][j];
				}
			}

			int brute = temp;
			for (int i = 0; i < cctvs.size(); i++) {
				int dir = brute % 4;
				brute /= 4;

				CCTV cur = cctvs.get(i);
				if (cur.no == 1) {
					canWatch(cur, dir);
				} else if (cur.no == 2) {
					canWatch(cur, dir);
					canWatch(cur, (dir + 2) % 4);
				} else if (cur.no == 3) {
					canWatch(cur, dir);
					canWatch(cur, (dir + 1) % 4);
				} else if (cur.no == 4) {
					canWatch(cur, dir);
					canWatch(cur, (dir + 1) % 4);
					canWatch(cur, (dir + 2) % 4);
				} else {
					canWatch(cur, dir);
					canWatch(cur, (dir + 1) % 4);
					canWatch(cur, (dir + 2) % 4);
					canWatch(cur, (dir + 3) % 4);
				}
			}

			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						cnt++;
					}
				}
			}

			if (min > cnt) {
				min = cnt;
			}

		}

		System.out.println(min);

	}

	private static void canWatch(CCTV cctv, int dir) {

		int nr = cctv.r;
		int nc = cctv.c;
		while (true) {
			nr += dr[dir];
			nc += dc[dir];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				return;
			if (map[nr][nc] == 6)
				return;
			if (map[nr][nc] != 0)
				continue;

			map[nr][nc] = 7;
		}
	}

}
