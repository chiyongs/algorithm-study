package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 3. 24.
 * @see https://www.acmicpc.net/problem/9095
 * @performance 11516	88
 * @category #DP
 * @note
 */
public class BOJ_S3_9095_123더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] d= new int[12];

		d[1]=1;
		d[2]=2;
		d[3]=4;
		for(int i=4;i<=11;i++) {
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
		
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());	
			sb.append(d[n]).append("\n");			
		}
		
		System.out.println(sb.toString());
	}
}
