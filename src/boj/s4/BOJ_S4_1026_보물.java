package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 17.
 * @see https://www.acmicpc.net/problem/1026
 * @performance 18316	228
 * @category #정렬
 * @note 
 */
public class BOJ_S4_1026_보물 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Integer[] B = new Integer[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B, (o1,o2) -> o2-o1);
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += (A[i] * B[i]);
		}
		
		System.out.println(sum);
	}

}
