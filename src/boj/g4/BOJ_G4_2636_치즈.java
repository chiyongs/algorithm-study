package boj.g4;

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
 * @since 2022. 3. 30.
 * @see https://www.acmicpc.net/problem/2636
 * @performance 14916	116
 * @category #BFS
 * @note  #치즈 외곽을 어떻게 찾을 것인가
 */
public class BOJ_G4_2636_치즈 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		int time = 0;
		while (true) {
			time++;
			boolean[][] visited = new boolean[n][m];
			Queue<int[]> Q = new LinkedList<>();
			Q.offer(new int[] { 0, 0 });
			visited[0][0] = true;

			while (!Q.isEmpty()) {
				int[] cur = Q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];

					if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc])
						continue;
					if (map[nr][nc] == 1)
						map[nr][nc] = 3;
					if (map[nr][nc] == 0) {
						Q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			
			List<int[]> list = new ArrayList<>();
			int isOnehourLeft = 0;
			int chz = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] == 1) {
						isOnehourLeft++;
					}
					if(map[i][j] == 3) {
						chz++;
						list.add(new int[] {i,j});
					}
				}
			}
			
			if(isOnehourLeft > 0) {
				for(int[] l : list) {
					map[l[0]][l[1]] = 0;
				}
			} else {
				answer = chz;
				break;
			}
			
		}
		
		System.out.println(time);
		System.out.println(answer);

	}

}
