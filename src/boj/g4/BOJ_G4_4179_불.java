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
 * @since 2022. 2. 24.
 * @see https://www.acmicpc.net/problem/4179
 * @performance 108860	640
 * @category #BFS #지훈이의 움직임과 불의 움직임을 같이 생각해야함
 * @note
 */

public class BOJ_G4_4179_불 {
	
	static int R,C,cnt;
	static char[][] map;
	static int[][] distance;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		distance = new int[R][C];
		List<Integer[]> fire = new ArrayList<>();
		Integer[] start = new Integer[3];
		
		for(int r=0;r<R;r++) {
			String input = br.readLine();
			for(int c=0;c<C;c++) {
				distance[r][c] = -1;
				map[r][c] = input.charAt(c);
				if(input.charAt(c) == 'J') {
					start[0] = r;
					start[1] = c;
					start[2] = 1;
				}
				if(input.charAt(c) == 'F') {
					fire.add(new Integer[] {r,c,2});
				}
			}
		}
		
		
		Queue<Integer[]> Q = new LinkedList<>();
		for(Integer[] f : fire) {
			Q.offer(f);
			visited[f[0]][f[1]] = true;
		}
		Q.offer(start);
		distance[start[0]][start[1]] = 0;
		
		while(!Q.isEmpty()) {
			Integer[] cur = Q.poll();
			if(cur[2] == 1) {
				for(int d=0;d<4;d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr<0||nc<0||nr>=R||nc>=C) {
						System.out.println(distance[cur[0]][cur[1]]+1);
						return;
					}					
					if(visited[nr][nc] || distance[nr][nc] != -1 || map[nr][nc] == '#') continue;
					
					distance[nr][nc] = distance[cur[0]][cur[1]]+1;
					Q.offer(new Integer[] {nr,nc, cur[2]});
				}				
				
			} else if(cur[2] == 2) {
				for(int d=0;d<4;d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr<0||nc<0||nr>=R||nc>=C) {
						continue;
					}
					if(visited[nr][nc] || map[nr][nc] == '#') continue;
					
					visited[nr][nc] = true;
					Q.offer(new Integer[] {nr,nc, cur[2]});
				}
			}
			
			
		}
		
		System.out.println("IMPOSSIBLE");
		
				
	}	
	
}
