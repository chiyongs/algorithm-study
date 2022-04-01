package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 1.
 * @see https://www.acmicpc.net/problem/4485
 * @performance 19324	188
 * @category #최소비용경로#다익스트라
 * @note
 */

public class BOJ_G4_4485_녹색옷입은애가젤다지 {
	
	static class Node implements Comparable<Node>{
		int d, r, c;
		
		public Node(int d, int r, int c) {
			this.d=d;
			this.r=r;
			this.c=c;
		}

		@Override
		public int compareTo(Node o) {
			return this.d - o.d;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = -1;
		StringBuilder sb = new StringBuilder();
		int t = 1;

		while ((N = Integer.parseInt(br.readLine())) != 0) {
			Node[][] map = new Node[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = new Node(Integer.parseInt(st.nextToken()),i,j);
				}
			}

			int[][] distance = new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0,0,0));
			distance[0][0] = 0;
						
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(distance[cur.r][cur.c]!= cur.d) continue;
				
				for(int d=0;d<4;d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if(nr<0||nc<0||nr>=N||nc>=N) continue;
					if(distance[nr][nc] <= (distance[cur.r][cur.c]+ map[nr][nc].d)) continue;
					
					distance[nr][nc] = distance[cur.r][cur.c]+ map[nr][nc].d;
					pq.offer(new Node(distance[nr][nc],nr,nc));
				}
				
				
			}
			int answer = distance[N-1][N-1];
			int init = map[0][0].d;
			sb.append("Problem ").append(t++).append(": ").append(init+answer).append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
