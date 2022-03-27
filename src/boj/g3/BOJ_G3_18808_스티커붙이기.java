package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * @author chiyongs
 * @since 2022. 3. 15.
 * @see https://www.acmicpc.net/problem/18808
 * @performance 16168	188
 * @category #구현
 * @note 
 * 		 
 */
public class BOJ_G3_18808_스티커붙이기 {

	static class Sticker {
		List<int[]> coords = new ArrayList<>();
		int[][] stk;
		
		public Sticker(int r, int c) {
			stk = new int[r][c];
		}

		public void addCoords(int r, int c) {
			coords.add(new int[] { r, c });
		}
		
		public void rotate() {
			int n = stk.length;
		    int m = stk[0].length;
		    int[][] rotate = new int[m][n];
		    
		    coords = new ArrayList<>();

		    for (int i = 0; i < rotate.length; i++) {
		        for (int j = 0; j < rotate[i].length; j++) {
		        	int val = stk[n-1-j][i];
		            rotate[i][j] = val;
		            if(val == 1) {
		            	addCoords(i,j);
		            }
		        }
		    }
		    
		    stk = new int[m][n];
		    
		    for(int i=0;i<m;i++) {		    	
		    	System.arraycopy(rotate[i], 0, stk[i], 0, n);
		    }

		}
		
	}

	static int[][] screen;
	static int N, M,R,C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		screen = new int[N][M];

		List<Sticker> stickers = new ArrayList<>();

		for (int i = 0; i < K; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			Sticker sticker = new Sticker(R,C);
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < C; c++) {
					int val = Integer.parseInt(st.nextToken());
					sticker.stk[r][c] = val;
					if (val == 1) {
						sticker.addCoords(r, c);
					}
				}
			}
			
			stickers.add(sticker);
		}

		
		for (int i = 0; i < K; i++) {
			Sticker sticker = stickers.get(i);
			boolean flag = false;
			for(int n=0;n<4;n++) {
				outer:for(int r=0;r<N;r++) {
					for(int c=0;c<M;c++) {
						if(sticker.stk[0][0] != 0 && screen[r][c] != 0) continue;
						flag = canAttach(r, c, sticker);
						if(flag) break outer;
					}
				}
				if(flag) break;
				sticker.rotate();
			}

		}
		
		int answer = 0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(screen[r][c] == 1) answer++; 
			}
		}
		
		System.out.println(answer);
		
	}


	private static boolean canAttach(int r, int c, Sticker sticker) {
		for (int i = 0; i < sticker.coords.size(); i++) {
			int[] cur = sticker.coords.get(i);
			if(r+cur[0] >= N || c+cur[1] >= M) return false;
			if (screen[r + cur[0]][c + cur[1]] == 0) {
				continue;
			} else {
				return false;
			}
		}

		for (int i = 0; i < sticker.coords.size(); i++) {
			int[] cur = sticker.coords.get(i);

			screen[r + cur[0]][c + cur[1]] = 1;

		}
		return true;
	}

}
