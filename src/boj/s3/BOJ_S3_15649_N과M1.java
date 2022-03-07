package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 7.
 * @see https://www.acmicpc.net/problem/15649
 * @performance 20472	180
 * @category #순열
 * @note
 */
public class BOJ_S3_15649_N과M1 {
	
	static int N,M,numbers[];
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected= new boolean[N];
		numbers = new int[M];
		permu(0);
		System.out.println(sb.toString());
	}
	
	
	private static void permu(int cnt) {
		if(cnt == M) {
			for(int x:numbers) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			numbers[cnt] = i+1;
			permu(cnt+1);
			isSelected[i] =false;
		}
	}
}
