package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 27.
 * @see https://www.acmicpc.net/problem/2212
 * @performance 15040	156
 * @category #그리디
 * @note
 */
public class BOJ_G5_2212_센서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] diff = new int[N-1];
		for(int i=0;i<N-1;i++) {
			diff[i] = Math.abs(arr[i] - arr[i+1]);
		}
		
		Arrays.sort(diff);
		
		int answer = 0;
		for(int i=0;i<N-K;i++) {
			answer += diff[i];
		}
		
		System.out.println(answer);

	}

}
