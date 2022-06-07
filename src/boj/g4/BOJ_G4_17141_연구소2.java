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
 * @since 2022. 5. 17.
 * @see https://www.acmicpc.net/problem/17141
 * @performance 39272	184
 * @category #BFS
 * @note 
 */
public class BOJ_G4_17141_연구소2 {
	
	
	static class Virus {
		int r,c,depth;
		
		public Virus(int r, int c) {
			this.r = r;
			this.c = c;
			this.depth = 0;
		}
		
		public Virus(int r, int c, int depth) {
			this(r,c);
			this.depth = depth;
		}
		
	}
	
	static int N,M,map[][];
	static List<Virus> virus;
	static Virus[] selected;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int answer, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		virus = new ArrayList<>();
		selected = new Virus[M];
		answer = Integer.MAX_VALUE;
		cnt = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) cnt++;
				if(num == 2) {
					virus.add(new Virus(i,j));
					cnt++;
				}
				map[i][j] = num;
			}
		}
		
		choose(0,0);
		
		if(answer == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(answer);

	}
	
	
	private static int bfs() {
		Queue<Virus> Q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		for(int i=0;i<M;i++) {
			Q.offer(selected[i]);
			visited[selected[i].r][selected[i].c] = true; 
		}
		
		int time = 0;
		int temp_cnt = 0;
		while(!Q.isEmpty()) {
			Virus cur = Q.poll();
			if(cur.depth > time) time = cur.depth;
			
			for(int d=0;d<4;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc>=N||map[nr][nc]==1) continue;
				if(visited[nr][nc]) continue;
				temp_cnt++;
				Q.offer(new Virus(nr,nc,cur.depth+1));
				visited[nr][nc] = true;
			}
		}
	
		if(temp_cnt+M < cnt) time = Integer.MAX_VALUE;
		
		return time;
		
		
	}
	
	private static void choose(int cnt, int start) {
		if(cnt == M) {
			int time = bfs();

			if(time < answer) answer = time;
			return;
		}
		
		for(int i=start;i<virus.size();i++) {
			selected[cnt] = virus.get(i);
			choose(cnt+1, i+1);
		}
	}

}
