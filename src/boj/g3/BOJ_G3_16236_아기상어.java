package boj.g3;

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
 * @since 2022. 2. 23.
 * @see https://www.acmicpc.net/problem/16236
 * @performance 22320	164
 * @category #BFS #구현 #꼭 다시 풀어보자
 * @note
 */

public class BOJ_G3_16236_아기상어 {

	static class BabyShark {
		int size,d=0;
		int r, c;
	}

	static class Coord {
		int r, c;
		int d;
		
		public Coord(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Coord [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
		
		
	}
	
	static int[][] map;
	static boolean[][] visited;
	static List<Coord> fishes;
	static int N,M,time;
	static BabyShark bs;
	static int D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		
		bs = new BabyShark();
		bs.size = 2;
		D = 0;
		time = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 9) {
					bs.r = i;
					bs.c = j;
					map[i][j] = 0;
				} else {
					map[i][j] = x;
				}
			}
		}
				
		int cnt = 0;
		while(true) {
			fishes= new ArrayList<>();
			visited = new boolean[N][N];
			bfs(new Coord(bs.r,bs.c,0));
			
			if(fishes.size() == 0) {
				System.out.println(time);
				return;
			}
			
			Coord fish = fishes.get(0);
			
			for(int i=1,size=fishes.size();i<size;i++) {
				if(fish.d > fishes.get(i).d) {
					fish = fishes.get(i);
				}
				if(fish.d == fishes.get(i).d) {
					if(fish.r > fishes.get(i).r) {
						fish = fishes.get(i);
					}
				}
			}
			
			time += fish.d;
			map[fish.r][fish.c]= 0; 
			cnt++;
			
			if(cnt == bs.size) {
				bs.size++;
				cnt = 0;
			}
			
			bs.r = fish.r;
			bs.c = fish.c;			
		}
		
	}
	
	static int[][] deltas = {{-1,0},{0,-1},{1,0},{0,1}};
	
	private static void bfs(Coord start) {
		Queue<Coord> queue = new LinkedList<>();
		 
		queue.offer(start);
		visited[start.r][start.c]= true; 
		
		while(!queue.isEmpty()) {
			Coord cur = queue.poll();
			
			for(int d=0;d<4;d++) {
				int nr = cur.r + deltas[d][0];
				int nc = cur.c + deltas[d][1];
				
				if(0<= nr && nr < N && 0<= nc && nc<N && !visited[nr][nc] && bs.size >= map[nr][nc]) {
					
					if(bs.size>map[nr][nc] && map[nr][nc] != 0) {
						queue.offer(new Coord(nr,nc,cur.d+1));
						fishes.add(new Coord(nr,nc,cur.d+1));
						visited[nr][nc] =true;
					} else if(bs.size == map[nr][nc] || map[nr][nc] == 0) {
						queue.offer(new Coord(nr,nc,cur.d+1));
						visited[nr][nc] = true;
					}
				}
			}			
		}		
	}	
	

}
