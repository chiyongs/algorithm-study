package boj.s3;

import java.util.Scanner;


/**
 * @author chiyongs
 * @since 2022. 3. 9.
 * @see https://www.acmicpc.net/problem/15650
 * @performance 12864	124
 * @category #조합
 * @note
 */
public class BOJ_S3_15650_N과M2 {
	
	static int N,M,input[],numbers[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		numbers = new int[M];
		for(int i=0;i<N;i++) {
			input[i] = i+1;
		}
		combination(0,0);
		
		System.out.println(sb.toString());
		sc.close();
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<N;i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}

}
