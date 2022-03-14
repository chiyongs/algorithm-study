package boj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author chiyongs
 * @since 2022. 2. 22.
 * @since 2022. 3. 14.
 * @see https://www.acmicpc.net/problem/2309
 * @performance 11552	76 / 11496	76
 * @category #조합
 * @note #데이터 추가로 인해 재채점 -> 실패
 * 이유 : 합이 100이 되는 난쟁이들의 조합이 여러 개일때 한번만 출력해야하지만
 * 모든 조합을 다 출력했기 때문!
 */

public class BOJ_B2_2309_일곱난쟁이 {
	
	static int[] input, numbers;
	static int N=9,R=7;
	static boolean isComp = false;
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
		if(isComp) return;
		if(cnt==R && !isComp) {
			int sum = 0;
			for(int i=0;i<R;i++) {
				sum+=numbers[i];
			}
			if(sum==100) {
				isComp = true;
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
