package boj;

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
 * @since 2022. 4. 1.
 * @see https://www.acmicpc.net/problem/1194
 * @performance 16564	132
 * @category #BFS #비트마스킹
 * @note 비트마스킹을 못해서 키랑 층 변수 두개로 해결
 */
public class BOJ_G1_1194_달이차오른다 {

	static class Status {
		int r, c;
		String key;
		int floor;

		public Status(int r, int c, String key, int floor) {
			this.r = r;
			this.c = c;
			this.key = key;
			this.floor = floor;
		}		
		
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<int[]> exit = new ArrayList<>();
		char[][] map = new char[N][M];
		int sr = 0;
		int sc = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] - '0' == 0) {
					sr = i;
					sc = j;
				}
				if (map[i][j] == '1') {
					exit.add(new int[] { i, j });
				}
			}
		}

		int[][][] distance = new int[N][M][64];
		Queue<Status> Q = new LinkedList<>();
		Q.offer(new Status(sr, sc, "", 0));
		distance[sr][sc][0] = 1;
		int answer = Integer.MAX_VALUE;

		while (!Q.isEmpty()) {
			Status cur = Q.poll();
			
			if (map[cur.r][cur.c] == '1') {
				System.out.println(distance[cur.r][cur.c][cur.floor]-1);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '#' || distance[nr][nc][cur.floor] != 0)
					continue;

				if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					boolean hasKey = false;
					for (int i = 0; i < cur.key.length(); i++) {
						if (cur.key.charAt(i) == map[nr][nc]) {
							hasKey = true;
							break;
						}
					}

					if (hasKey) {
						distance[nr][nc][cur.floor] = distance[cur.r][cur.c][cur.floor] + 1;
						Q.offer(new Status(nr, nc, cur.key, cur.floor));
					}

				} else {
					if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						boolean isDup = false;
						for(int i=0;i<cur.key.length();i++) {
							if(cur.key.charAt(i) == Character.toUpperCase(map[nr][nc]) ) {
								isDup = true;
								break;
							}
						}
						if(isDup) {
							Status status = new Status(nr,nc,cur.key,cur.floor);
							Q.offer(status);
							distance[nr][nc][cur.floor] = distance[cur.r][cur.c][cur.floor] + 1;
						} else {
							int floor = map[nr][nc] - 'a';
							floor = (1 << floor) + cur.floor;
							Status status = new Status(nr, nc, cur.key + Character.toUpperCase(map[nr][nc]), floor);
							Q.offer(status);
							distance[nr][nc][floor] = distance[cur.r][cur.c][cur.floor] + 1;
						}
						
					} else {
						distance[nr][nc][cur.floor] = distance[cur.r][cur.c][cur.floor] + 1;
						Q.offer(new Status(nr, nc, cur.key, cur.floor));
					}
				}
			}
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer-1);
		}
	}

}
