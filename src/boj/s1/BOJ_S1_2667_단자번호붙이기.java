package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chiyongs
 * @since 2022. 6. 1.
 * @see https://www.acmicpc.net/problem/2667
 * @performance 11612	92
 * @category #DFS #BFS
 * @note 
 * 		 
 */
public class BOJ_S1_2667_단자번호붙이기 {
	
	static int[][] map;
	static boolean[][] visited;
	static int max,N,cnt;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		List<Integer> answer = new ArrayList<>();
		int result = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]) continue;
				
				if(map[i][j] == 1) {
					cnt=1;
					result++;
					dfs(i,j);
					answer.add(cnt);
				}
			}
		}
		
		Collections.sort(answer);
		
		System.out.println(result);
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
		
	}
	
	static void dfs(int r, int c) {		
		
		visited[r][c] = true;
		
		for(int d=0;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != 1 || visited[nr][nc]) continue;
			
			cnt++;
			dfs(nr,nc);
		}
	}
}
