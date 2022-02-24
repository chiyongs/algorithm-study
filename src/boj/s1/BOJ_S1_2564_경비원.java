package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 24.
 * @see https://www.acmicpc.net/problem/2564
 * @performance 11580	80
 * @category #구현#IM대비문제!
 * @note
 */

public class BOJ_S1_2564_경비원 {
	
	static int R,C;
	static int dloc,dx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());		
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] store = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			store[i][0] = dir;
			store[i][1] = x;
			
		}
		
		st = new StringTokenizer(br.readLine()," ");
		dloc = Integer.parseInt(st.nextToken());
		dx = Integer.parseInt(st.nextToken());		
		
		int result = 0;
		for(int i=0;i<N;i++) {
			int dir = store[i][0];
			int x = store[i][1];
			if(dloc == 1) {
				if(dir == 1) {
					result += Math.abs(dx - x);
				} else if(dir == 2) {
					int right = R - dx + C + R - x;
					int left = dx + C + x;
					result += Math.min(left, right);
				} else if(dir == 3) {
					result += dx + x;
				} else if(dir == 4) {
					result += R - dx + x;
				}
			} else if(dloc == 2) {
				if(dir == 1) {
					int right = R - dx + C + R - x;
					int left = dx + C + x;
					result += Math.min(left, right);
				} else if(dir == 2) {
					result += Math.abs(dx - x);
				} else if(dir == 3) {
					result += dx + C - x;
				} else if(dir == 4) {
					result += R - dx + C - x;
				}
			} else if(dloc == 3) {
				if(dir == 1) {
					result += dx + x;
				} else if(dir == 2) {
					result += C - dx + x;
				} else if(dir == 3) {
					result += Math.abs(dx-x);
				} else if(dir == 4) {
					int up = dx + R + x;
					int down = C - dx + R + C - x;
					result += Math.min(up, down);
				}
			} else if(dloc == 4) {
				if(dir == 1) {
					result += R - x + dx;
				} else if(dir == 2) {
					result += C - x + R - dx;
				} else if(dir == 3) {
					int up = dx + R + x;
					int down = C - dx + R + C - x;
					result += Math.min(up, down);
				} else if(dir == 4) {
					result += Math.abs(dx-x);
				}
			}
		}
		
		System.out.println(result);

	}

}
