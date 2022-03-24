package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 3. 25.
 * @see https://www.acmicpc.net/problem/2579
 * @performance 11620	76
 * @category #DP
 * @note
 */
public class BOJ_S3_2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] st = new int[301];
		int[][] d = new int[301][2];

		for(int t=1;t<=T;t++) {
			st[t] = Integer.parseInt(br.readLine());
		}
		
		d[1][0] = st[1];
		d[1][1] = 0;
		d[2][0] = st[2];
		d[2][1] = st[1]+st[2];
		for(int i=3;i<=T;i++) {
			d[i][0] = Math.max(d[i-2][0], d[i-2][1]) + st[i];
			d[i][1] = d[i-1][0] + st[i];
		}
		
		System.out.println(Math.max(d[T][0], d[T][1]));
	}

}
