package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chiyongs
 * @since 2022. 2. 24.
 * @see https://www.acmicpc.net/problem/10026
 * @performance 13924	112
 * @category #BFS로 풀었는데 DFS로 풀어야하나..
 * @note
 */

public class BOJ_G5_10026_적록색약 {
	
	static class Pixel {
		int r,c;
		char color;
		
		public Pixel(int r, int c, char color) {
			this.r = r;
			this.c = c;
			this.color = color;
		}		
	}
	
	static int N,cnt,cntBlind;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] painting = new int[N][N];
		int[][] blindPainting = new int[N][N];
		visited = new boolean[N][N];
		List<Pixel> red = new ArrayList<>();
		List<Pixel> blind = new ArrayList<>();
		List<Pixel> blue = new ArrayList<>();
		List<Pixel> green = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				painting[i][j] = input.charAt(j);
				if(painting[i][j] == 'R') {
					red.add(new Pixel(i,j,'R'));
					blind.add(new Pixel(i,j,'X'));
					blindPainting[i][j] = 'X';
				} else if(painting[i][j] == 'B') {
					blue.add(new Pixel(i,j,'B'));
					blindPainting[i][j] = 'B';
				} else if(painting[i][j] == 'G') {
					green.add(new Pixel(i,j,'G'));
					blind.add(new Pixel(i,j,'X'));
					blindPainting[i][j] = 'X';
				}
			}
		}
		
		for(int i=0,size=red.size();i<size;i++) {
			Pixel p = red.get(i);
			if(!visited[p.r][p.c]) bfs(red.get(i),'R',painting);
		}		
		for(int i=0,size=blue.size();i<size;i++) {
			Pixel p = blue.get(i);
			if(!visited[p.r][p.c]) bfs(blue.get(i),'B',painting);
		}
		for(int i=0,size=green.size();i<size;i++) {
			Pixel p = green.get(i);
			if(!visited[p.r][p.c]) bfs(green.get(i),'G',painting);
		}
		System.out.printf("%d ",cnt);
		cnt = 0;
		visited = new boolean[N][N];
		for(int i=0,size=blind.size();i<size;i++) {
			Pixel p = blind.get(i);
			if(!visited[p.r][p.c]) bfs(blind.get(i),'X',blindPainting);
		}
		for(int i=0,size=blue.size();i<size;i++) {
			Pixel p = blue.get(i);
			if(!visited[p.r][p.c]) bfs(blue.get(i),'B',blindPainting);
		}		
		System.out.printf("%d",cnt);

	}
	
	private static void bfs(Pixel start, char color,int[][] painting) {
		Queue<Pixel> Q = new LinkedList<>();
		
		Q.offer(start);
		visited[start.r][start.c] = true;
		
		while(!Q.isEmpty()) {
			Pixel cur = Q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr<0||nc<0||nr>=N||nc>=N) continue;
				if(visited[nr][nc] || painting[nr][nc] != color) {
					continue;
				}				
				visited[nr][nc] = true;
				Q.offer(new Pixel(nr,nc,color));
			}			
		}
		cnt++;
	}
}
