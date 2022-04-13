package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 13.
 * @see https://www.acmicpc.net/problem/9205
 * @performance 13040	108
 * @category #BFS
 * @note 기존의 BFS탐색처럼 배열을 만들지 않고 주어진 좌표들을 바탕으로
 * 현재 위치에서 갈 수 있는지를 판단하고 갈 수 있으면 가본다.
 */
public class BOJ_S1_9205_맥주마시면서걸어가기 {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}	
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			Point[] map = new Point[N + 2];
		
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[i] = new Point(r, c);

			}

			Queue<Point> Q = new LinkedList<>();
			Q.offer(map[0]);
			boolean[] visited = new boolean[N + 2];
			visited[0] = true;

			boolean isHappy = false;
			while (!Q.isEmpty()) {
				Point cur = Q.poll();
				
				if(cur.r == map[N+1].r && cur.c == map[N+1].c) {
					isHappy = true;
					break;
				}
				
				for (int d = 0; d < 4; d++) {
					for(int i=1;i<N+2;i++) {
						if(visited[i]) continue;
						int distance = Math.abs(map[i].r - cur.r) + Math.abs(map[i].c - cur.c);
						if(distance <= 1000) {
							Q.offer(map[i]);
							visited[i] = true;
						}
					}
				}
			}
			if(isHappy) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		}

	}

}
