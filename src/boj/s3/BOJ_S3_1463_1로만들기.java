package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 3. 24.
 * @see https://www.acmicpc.net/problem/1463
 * @performance 15480	112
 * @category #DP
 * @note
 */
public class BOJ_S3_1463_1로만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] D = new int[num+1];
		D[1] = 0;
		for(int i=2;i<=num;i++) {
			D[i] = D[i-1] + 1;
			if(i % 2 == 0) D[i] = Math.min(D[i/2] + 1,D[i]);
			if(i % 3 == 0) D[i] = Math.min(D[i/3] + 1,D[i]);
		}
		
		System.out.println(D[num]);
		
	}

}
