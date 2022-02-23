package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 23.
 * @see https://www.acmicpc.net/problem/1926
 * @performance 49028	440
 * @category #BFS
 * @note
 */

public class BOJ_S1_1926_그림 {
	
	static int n,m,screen[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		screen = new int[n][m];
		
		for(int r=0;r<n;r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=0;c<m;c++) {
				screen[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] visited = new boolean[n][m];
		max = 0;
		int cnt = 0;
		for(int r=0;r<n;r++) {
			for(int c=0;c<m;c++) {
				if(!visited[r][c] && screen[r][c] == 1) {
					bfs(new Integer[]{r,c},visited);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);

	}
	
	private static void bfs(Integer[] start, boolean[][] visited) {
		Queue<Integer[]> q = new LinkedList<>();
		visited[start[0]][start[1]] = true;
		
		q.offer(start);
		int size = 1;
		
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= n || nc<0 || nc>=m ) continue;
				if(visited[nr][nc] || screen[nr][nc] != 1) continue;
				
				visited[nr][nc] = true;
				size++;
				q.offer(new Integer[] {nr,nc});
			}
		}
		if(size > max) {
			max = size;
		}
	}

}
