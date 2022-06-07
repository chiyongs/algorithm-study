package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 18.
 * @see https://www.acmicpc.net/problem/1080
 * @performance 11640	80
 * @category #정렬 #그리디
 * @note 
 * 		 
 */
public class BOJ_S1_1080_행렬 {
	
	static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] A = new char[N][M];
		
		for(int i=0;i<N;i++) {
			char[] input = br.readLine().toCharArray();
			A[i] = input;
		}
		
		char[][] B = new char[N][M];
		for(int i=0;i<N;i++) {
			char[] input = br.readLine().toCharArray();
			B[i] = input;
		}
		
		
		int cnt = 0;
		for(int i=0;i+3<=N;i++) {
			for(int j=0;j+3<=M;j++) {
				if(A[i][j] != B[i][j]) {
					flip(A,i,j);
					cnt++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(A[i][j] != B[i][j]) {
					System.out.println("-1");
					return;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
	private static void flip(char[][] A, int row, int col) {
		for(int i=row;i<row+3;i++) {
			for(int j=col;j<col+3;j++) {
				if(A[i][j] == '1') A[i][j] = '0';
				else A[i][j] = '1';
			}
		}
	}

}
