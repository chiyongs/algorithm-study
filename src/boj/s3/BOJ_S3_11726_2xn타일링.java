package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 4. 1.
 * @see https://www.acmicpc.net/problem/1244
 * @performance 11532	80
 * @category #DP
 * @note
 */
public class BOJ_S3_11726_2xn타일링 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[1001];
		d[1] = 1;
		d[2] = 2;
		
		for(int i=3;i<=n;i++) {
			d[i] = (d[i-1]+d[i-2]) % 10007;
		}
		
		System.out.println(d[n]);
	}

}
