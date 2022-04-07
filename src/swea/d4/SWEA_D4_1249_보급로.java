package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author cldyd
 * 다익스트라를 하기 위해서는 노드들과 boolean형 visited배열, int형 distance배열이 필요
 * 우선순위큐를 사용해서 갈 수 있는 노드 중 방문하지 않았고 경유 경로 
 *
 */
public class SWEA_D4_1249_보급로 {
	
	static class Node implements Comparable<Node>{
		int r, c, val;
		
		public Node(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}
		
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			Node[][] map = new Node[N][N];
			for(int i=0;i<N;i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					map[i][j] = new Node(i,j, ch[j]-'0');
				}
			}
			
			boolean[][] visited = new boolean[N][N];
			int[][] distance = new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(map[0][0]);
			distance[0][0] = 0;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visited[cur.r][cur.c]) {
					continue;
				}
				
				visited[cur.r][cur.c]= true;
				
				for(int d=0;d<4;d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					
					if(!visited[nr][nc] && distance[nr][nc] > map[nr][nc].val + distance[cur.r][cur.c]) {
						distance[nr][nc] = map[nr][nc].val + distance[cur.r][cur.c];
						pq.offer(new Node(nr,nc, distance[nr][nc]));
					}
				}
				
			}
			
			sb.append("#").append(t).append(" ").append(distance[N-1][N-1]).append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
