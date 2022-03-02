package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 2.
 * @see https://www.acmicpc.net/problem/1074
 * @performance 11500	76
 * @category #재귀
 * @note
 */
public class BOJ_S1_1074_Z {
	
	static int N,cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); 
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		int result = Z(r,c,size);
		System.out.println(result);
	}
	
	private static int Z(int r, int c, int size) {
		if(size == 0) {
			return 0;
		}
		
		int half = size/2;
		if(0<=r && r<half && 0<=c && c<half) {
			return Z(r,c,half);
		} else if(0<=r&& r<half && half <=c && c<size) {
			return half*half + Z(r,c-half,half);
		} else if(half<=r && r < size && 0<=c && c<half) {			
			return 2*(half*half)+Z(r-half, c, half);
		} else {
			return 3*(half*half)+Z(r-half, c-half, half);
		}
	}

}
