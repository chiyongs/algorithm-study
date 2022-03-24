package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 25.
 * @see https://www.acmicpc.net/problem/1149
 * @performance 12144	92
 * @category #DP
 * @note
 */
public class BOJ_S1_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
				
		int[][] house = new int[T][3];
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			house[t][0] = Integer.parseInt(st.nextToken());
			house[t][1] = Integer.parseInt(st.nextToken());
			house[t][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] d = new int[T][3];
		d[0][0] = house[0][0];
		d[0][1] = house[0][1];
		d[0][2] = house[0][2];
		for(int i=1;i<T;i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + house[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + house[i][1];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + house[i][2];
		}
		
		int min = Math.min(d[T-1][0], d[T-1][1]);
		System.out.println(Math.min(min, d[T-1][2]));
	}

}
