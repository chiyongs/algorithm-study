package boj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author chiyongs
 * @since 2022. 2. 22.
 * @see https://www.acmicpc.net/problem/2309
 * @performance 11552	76
 * @category #조합
 * @note
 */

public class BOJ_B2_2309_일곱난쟁이 {
	
	static int[] input, numbers;
	static int N=9,R=7;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new int[N];
		numbers = new int[R];
		for(int i=0;i<9;i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0,0);
		
		System.out.println(sb.toString());
	}
	
	private static void combination(int cnt, int start) {
		if(cnt==R) {
			int sum = 0;
			for(int i=0;i<R;i++) {
				sum+=numbers[i];
			}
			if(sum==100) {
				Arrays.sort(numbers);
				for(int x: numbers) {
					sb.append(x).append("\n");
				}
			}
			return;
		}
		
		for(int i=start;i<N;i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}

}
