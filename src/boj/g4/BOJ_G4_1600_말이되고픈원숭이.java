package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 30.
 * @see https://www.acmicpc.net/problem/1600
 * @performance 94376	592
 * @category #BFS
 * @note  #말이 되어서 가본 곳과 원숭이로 가는 곳을 구별해보자
 */
public class BOJ_G4_1600_말이되고픈원숭이 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[] hr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hc = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> Q = new LinkedList<>();
		int[][][] distance = new int[n][m][K+1];
		Q.offer(new int[] { 0, 0, 0 });
		for(int i=0;i<=K;i++) {
			distance[0][0][i] = 1;
		}
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc>= m || distance[nr][nc][cur[2]] != 0 || map[nr][nc] != 0) continue;
				
				Q.offer(new int[] {nr,nc,cur[2]});
				distance[nr][nc][cur[2]] = distance[cur[0]][cur[1]][cur[2]] + 1;
			}
			
			if(cur[2] < K) {
				for(int d=0;d<8;d++) {
					int nr = cur[0] + hr[d];
					int nc = cur[1] + hc[d];
					
					if(nr < 0 || nc < 0 || nr >= n || nc>= m || distance[nr][nc][cur[2]+1] != 0 || map[nr][nc] != 0) continue;
					
					Q.offer(new int[] {nr,nc,cur[2]+1});
					distance[nr][nc][cur[2]+1] = distance[cur[0]][cur[1]][cur[2]] + 1;
				}
			}
		}
		
		int[] answers = new int[K+1];
		boolean canGo = false;
		for(int i=0;i<=K;i++) {
			answers[i] = distance[n-1][m-1][i];
			if(answers[i] != 0) {
				canGo = true;
			}
		}
		
		Arrays.sort(answers);
		
		if(canGo) {
			for(int i=0;i<=K;i++) {
				if(answers[i] != 0) {
					System.out.println(answers[i] -1);
					return;
				}
			}
		} else {
			System.out.println(-1);
		}
		
		
	}

}
