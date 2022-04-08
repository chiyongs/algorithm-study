package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 8.
 * @see https://www.acmicpc.net/problem/17135
 * @performance 14648	196
 * @category #조합 #구현 #4방탐색
 * @note 
 */
public class BOJ_G4_17135_캐슬디펜스 {

	static int N, M, D, map[][], enemies, archors[],answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		enemies = 0;
		answer = 0;
		archors = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				if (val == 1)
					enemies++;
			}
		}
		
		selectArchor(0, 0);
		
		System.out.println(answer);

	}

	private static void selectArchor(int cnt, int start) {
		if (cnt == 3) {
			int result = 0;
			int killed = 0;
			int[][] newMap = new int[N][M];
			copy(map, newMap);
				
			while(result < enemies) {
				int temp = shoot(newMap);
				killed += temp;
				result += temp;
				result += drop(newMap);
			}			
			
			if(answer < killed) {
				answer = killed;
			}
			
			return;
		}

		for (int i = start; i < M; i++) {
			archors[cnt] = i;
			selectArchor(cnt + 1, i + 1);
		}
	}
	
	private static int shoot(int[][] map) {
		int[][] coords = new int[3][2];
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			Arrays.fill(coords[i], Integer.MAX_VALUE);
			int distance = Integer.MAX_VALUE;
			int comp_c = M;
			int x = N >= D ? N-D : 0;
			for (int r = N - 1; r >= x; r--) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1) {
						int temp = N - r + Math.abs(archors[i] - c);
						if (temp <= D) {
							if (temp < distance) {
								distance = temp;								
								coords[i][0] = r;
								coords[i][1] = c;
								comp_c = c;
							} else if(temp == distance && c < comp_c) {
								coords[i][0] = r;
								coords[i][1] = c;
								comp_c = c;
							}
						}
					}
				}
			}
			
		}
		
		for (int i = 0; i < 3; i++) {
			int r = coords[i][0], c = coords[i][1];
			if(r == Integer.MAX_VALUE || c == Integer.MAX_VALUE) continue;
			if(map[r][c] == 1) {
				map[r][c] = 0;
				cnt++;
			}
		}
		
		return cnt;
	}

	private static int drop(int[][] map) {
		int cnt = 0;
		for (int j = 0; j < M; j++) {
			if (map[N - 1][j] == 1)
				cnt++;
		}

		for (int j = 0; j < M; j++) {
			for (int i = N - 2; i >= 0; i--) {
				map[i+1][j] = map[i][j];
			}
		}
		
		for(int i=0;i<M;i++) {
			map[0][i] = 0;
		}
		
		return cnt;
	}
	
	private static void copy(int[][] old, int[][] newMap) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				newMap[i][j] = old[i][j];
			}
		}
	}

}
