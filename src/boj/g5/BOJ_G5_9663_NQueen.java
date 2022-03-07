package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author chiyongs
 * @since 2022. 3. 7.
 * @see https://www.acmicpc.net/problem/9663
 * @performance 12256	6252
 * @category #백트래킹
 * @note
 */
public class BOJ_G5_9663_NQueen {
	
	static int[] arr;
	static int N,cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		nqueen(0);
		System.out.println(cnt);
	}
	
	private static void nqueen(int current) {		
		if(current == N) {
			cnt++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			arr[current] = i;
			if(canGo(current)) {
				nqueen(current+1);
			}
		}
	}
	
	private static boolean canGo(int current) {
		for(int i=0;i<current;i++) {
			if(arr[current] == arr[i]) return false;
			if(Math.abs(current - i) == Math.abs(arr[current] - arr[i])) return false;
		}
		return true;
	}
	
}
