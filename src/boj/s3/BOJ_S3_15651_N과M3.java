package boj.s3;

import java.util.Scanner;

/**
 * @author chiyongs
 * @since 2022. 3. 10.
 * @see https://www.acmicpc.net/problem/15651
 * @performance 114868	468
 * @category #중복순열
 * @note
 */
public class BOJ_S3_15651_N과M3 {
	
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
		
		permutation(0);
		System.out.println(sb.toString());
		sc.close();
	}
	
	private static void permutation(int cnt) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			numbers[cnt] = input[i];
			permutation(cnt+1);
		}
	}

}
