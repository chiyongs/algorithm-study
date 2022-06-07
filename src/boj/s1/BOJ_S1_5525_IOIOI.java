package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 5. 12.
 * @see https://www.acmicpc.net/problem/5525
 * @performance 24556	200
 * @category #문자열
 * @note 
 */
public class BOJ_S1_5525_IOIOI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int ioi_size = N*2+1;
		
		int[] memo = new int[M];
		int answer = 0;
		for(int i=2;i<M;i++) {
			if(S.charAt(i) == 'I' && S.charAt(i-1) == 'O') {
				memo[i] = memo[i-2] + 1;
				if(memo[i]>=N && S.charAt(i-ioi_size+1) == 'I') answer++;
			} else {
				memo[i] = 0;
			}
		}
		
		System.out.println(answer);

	}

}
