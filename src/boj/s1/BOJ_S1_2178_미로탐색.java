package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 24.
 * @see https://www.acmicpc.net/problem/2178
 * @performance 12440	108
 * @category #BFS
 * @note
 */


public class BOJ_S1_2178_미로탐색 {
	
	static int n,m,map[][],cnt;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			String input = br.readLine();
			for(int j=1;j<=m;j++) {
				map[i][j] = input.charAt(j-1) -'0';
			}
		}		
		
		bfs(new Integer[] {1,1,1});
		System.out.println(cnt);
		
	}
	
	private static void bfs(Integer[] start) {
		Queue<Integer[]> Q = new LinkedList<>();
		
		Q.offer(start);
		visited[start[0]][start[1]] = true;		
		
		while(!Q.isEmpty()) {
			Integer[] cur = Q.poll();			
			
			if(cur[0] == n && cur[1] == m) {
				cnt = cur[2];
				break;
			}
			for(int d=0;d<4;d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr<1||nc<1||nr>n||nc>m) continue;			
				if(visited[nr][nc] || map[nr][nc] != 1)	continue;				
				
				visited[nr][nc] = true;
				Q.offer(new Integer[] {nr,nc,cur[2]+1});
			}
			
			
		}
	}

}
