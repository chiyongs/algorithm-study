package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 6.
 * @see https://www.acmicpc.net/problem/14503
 * @performance 13128	96
 * @category #구현 #dfs
 * @note
 */
public class BOJ_G5_14503_로봇청소기 {

	static int N, M, map[][];
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		int[] robot = new int[3];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 3; i++) {
			robot[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[robot[0]][robot[1]] = true;
		move(robot, 1);

	}
	
	private static void move(int[] robot, int cnt) {		
		int r = robot[0], c=robot[1],dir=robot[2];
		int rot = 0;
		while(true) {
			int next = dir -1;
			if(next == -1) next = 3;
			if(rot == 4) {
				int nr = r + dr[(dir+2)%4];
				int nc = c + dc[(dir+2)%4];
				if(checkBehind(nr, nc, robot[2])) {
					System.out.println(cnt);
					System.exit(0);
				} else {					
					move(new int[] {nr,nc,dir},cnt);
				}
				return;
			}
			
			int nr = r+dr[next];
			int nc = c+dc[next];
			
			if(isIn(nr,nc) && map[nr][nc] != 1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				move(new int[] {nr,nc,next}, cnt+1);
			} else {
				dir = next;
				rot++;
			}
		}
	}

	private static boolean checkBehind(int r, int c, int dir) {
		if(map[r][c] == 1) return true;
		return false;
	}

	private static boolean isIn(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M)
			return false;
		return true;
	}

}
