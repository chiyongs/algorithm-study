package swea.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 4. 7.
 * @see 
 * @performance 25,080 kb 135 ms
 * @category #구현 #4방탐색 #BFS
 * @note
 */
public class SWEA_SAMPLE_1953_탈주범검거 {
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N,M,map[][];
	static int[][] moves = {{},{0,1,2,3},{0,1},{2,3},{0,3},{1,3},{1,2},{0,2}};
	static class Point {
		int r,c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Point> Q = new LinkedList<>();
			Q.offer(new Point(R,C));
			int[][] distance = new int[N][M];			
			distance[R][C] = 1;
			
			while(!Q.isEmpty()) {
				Point cur = Q.poll();
				
				int index = map[cur.r][cur.c];				
				for(int i=0;i<moves[index].length;i++) {
					int d = moves[index][i];
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if(isIn(nr,nc) && map[nr][nc] != 0 && distance[nr][nc] == 0 && isConnect(nr,nc,d)) {
						Q.offer(new Point(nr,nc));
						distance[nr][nc] = distance[cur.r][cur.c]+1; 
					}
				}
			}
			
			int answer = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(distance[i][j] != 0 && distance[i][j] <= L) {
						answer++;
					}
				}
			}
			
			System.out.println("#"+t+" "+answer);
			
		}
	}
	
	private static boolean isConnect(int nr, int nc, int d) {
		int next = map[nr][nc];
		int go = 0;
		if(d == 0) {
			go = 1;
		} else if(d == 1) {
			go = 0;
		} else if(d == 2) {
			go = 3;
		} else {
			go = 2;
		}
		
		return comp(moves[next], go);
	}
	
	private static boolean comp(int[] temp, int go) {
		for(int x:temp) {
			if(x == go) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isIn(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= M) return false;
		return true;
	}

}
