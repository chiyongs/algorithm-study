package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 3.
 * @see https://www.acmicpc.net/problem/4963
 * @performance 13532	120
 * @category #DFS #BFS
 * @note 
 * 		 
 */
public class BOJ_S2_4963_섬의개수 {
	
	static int w,h,map[][];
	static boolean[][] visited;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		while(w != 0 && h != 0) {
			map = new int[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[h][w];
			int answer = 0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						answer++;
						dfs(i,j);
					}
				}
			}
			
			sb.append(answer).append("\n");
			
			
			st = new StringTokenizer(br.readLine()," ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0;d<8;d++) {
			int nr = dr[d]+r;
			int nc = dc[d]+c;
			
			if(nr < 0 || nc < 0 || nr >= h || nc >= w || visited[nr][nc] || map[nr][nc] == 0) continue;
			
			dfs(nr,nc);
		}
	}

}
