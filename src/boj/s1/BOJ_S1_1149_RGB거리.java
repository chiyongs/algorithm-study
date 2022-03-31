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
		int n = Integer.parseInt(br.readLine());
		int[][] houses = new int[n+1][3];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			houses[i][0] = Integer.parseInt(st.nextToken());
			houses[i][1] = Integer.parseInt(st.nextToken());
			houses[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] d = new int[n+1][3];
		
		d[1][0] = houses[1][0];
		d[1][1] = houses[1][1];
		d[1][2] = houses[1][2];
		
		for(int i=2;i<=n;i++) {
			d[i][0] = Math.min(d[i-1][1],d[i-1][2])+houses[i][0];
			d[i][1] = Math.min(d[i-1][0],d[i-1][2])+houses[i][1];
			d[i][2] = Math.min(d[i-1][1],d[i-1][0])+houses[i][2];
		}
		
		int min = Math.min(d[n][0], d[n][1]);
		System.out.println(Math.min(min, d[n][2]));
	}

}
