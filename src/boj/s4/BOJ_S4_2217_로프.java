package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author chiyongs
 * @since 2022. 4. 4.
 * @see https://www.acmicpc.net/problem/2217
 * @performance 22408	256	
 * @category #그리디
 * @note
 */
public class BOJ_S4_2217_로프 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int max = 0;
		for(int i=0;i<n;i++) {
			int w = arr[i] * (n-i);
			if(max < w) {
				max = w;
			}
		}
		System.out.println(max);
	}
}
