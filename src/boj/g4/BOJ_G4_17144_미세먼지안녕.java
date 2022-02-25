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
 * @since 2022. 2. 25.
 * @see https://www.acmicpc.net/problem/17144
 * @performance 	168820	608
 * @category #BFS
 * @note 미세먼지 전파가 다른 미세먼지의 초기값에 영향을 끼치지 않으려 3차원 배열을 사용했는데
 * 		 애초에 Coord에서 자신의 미세먼지 양을 가지고 있었으면 더 좋은 코드가 되었을듯하다.
 */
public class BOJ_G4_17144_미세먼지안녕 {
	
	static class Coord {
		int r,c;
		boolean isUp;

		public Coord(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "C [r=" + r + ", c=" + c + ", isUp=" + isUp + "]";
		}

		public Coord(int r, int c, boolean isUp) {
			this.r = r;
			this.c = c;
			this.isUp = isUp;
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] cleanUpR = {0,-1,0,1};
	static int[] cleanUpC = {1,0,-1,0};
	static int[] cleanDownR = {0,1,0,-1};
	static int[] cleanDownC = {1,0,-1,0};
	static int R,C,T;
	static int[][][] room;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C][2];
		
		List<Coord> cleaner = new ArrayList<>();
		
		boolean isUp = true;
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=0;c<C;c++) {
				int x = Integer.parseInt(st.nextToken());
				if(x==-1) {
					cleaner.add(new Coord(r,c,isUp));
					isUp = false;
				}
				room[r][c][0] = x;
				room[r][c][1] = x;
			}
		}
						
		for(int t=0;t<T;t++) {	
			List<Coord> dust = new ArrayList<>();
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					room[r][c][0] = room[r][c][1];
					int x = room[r][c][1];
					if(x != 0 && x != -1) dust.add(new Coord(r,c));					
				}
			}
			spread(dust);			
			clean(cleaner);
		}		
		
		int sum = 0;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(room[r][c][1] != -1)	sum+=room[r][c][1];				
			}
		}
		
		System.out.println(sum);

	}
	
	private static void clean(List<Coord> cleaner) {
		Coord up = cleaner.get(0);
		Coord down = cleaner.get(1);
		for(int i=up.r-1;i>0;i--) {
			room[i][0][1] = room[i-1][0][1];
		}
		
		for(int i=0;i<C-1;i++) {
			room[0][i][1] = room[0][i+1][1];
		}
		
		for(int i=0;i<up.r;i++) {
			room[i][C-1][1] = room[i+1][C-1][1];
		}
		
		for(int i=C-1;i>1;i--) {
			room[up.r][i][1] = room[up.r][i-1][1];
		}
		
		room[up.r][1][1] = 0;
		
		for(int i=down.r+1;i<R-1;i++) {
			room[i][0][1] = room[i+1][0][1];
		}
		
		for(int i=0;i<C-1;i++) {
			room[R-1][i][1] = room[R-1][i+1][1];
		}
		
		for(int i=R-1;i>down.r;i--) {
			room[i][C-1][1] = room[i-1][C-1][1];
		}
		
		for(int i=C-1;i>1;i--) {
			room[down.r][i][1] = room[down.r][i-1][1];
		}
		
		room[down.r][1][1] = 0;
		
	}
	
	private static void spread(List<Coord> dust) {
		Queue<Coord> Q = new LinkedList<>();
		for(Coord d: dust) {
			Q.offer(d);
		}
		
		while(!Q.isEmpty()) {
			Coord cur = Q.poll();
			int cnt = 0;
			
			for(int d=0;d<4;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nc<0||nr<0||nc>=C||nr>=R) continue;
				if(room[nr][nc][0] == -1) continue;
				
				cnt++;
				room[nr][nc][1] += room[cur.r][cur.c][0]/5;
				
			}
			room[cur.r][cur.c][1] = room[cur.r][cur.c][1] - cnt*(room[cur.r][cur.c][0]/5);			
		}
	}

}
