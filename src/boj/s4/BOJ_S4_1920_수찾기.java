package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 4. 13.
 * @see https://www.acmicpc.net/problem/1920
 * @performance 103268	2640 70980	1632	
 * @category #이분탐색
 * @note
 */
public class BOJ_S4_1920_수찾기 {
	
	static int[] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			
//			find(num, start, end);	
			
//			System.out.println(find2(num));
			
			int result = Arrays.binarySearch(arr, num);
			if(result < 0) System.out.println(0);
			else System.out.println(1);
		}

	}
	
	private static int find2(int num) {
		int start = 0, end = N-1;
		
		while(start <= end) {
			int mid = (start+end) /2;
			
			if(num < arr[mid]) {
				end = mid - 1;
			} else if (num > arr[mid]) {
				start = mid + 1;
			} else return 1;
		}
		return 0;
	}
	
	private static void find(int num, int start, int end) {
		int mid = (start + end) / 2;
		if(num > arr[end] || num < arr[start]) {
			System.out.println(0);
			return;
		}
		if(arr[mid] == num || arr[start] == num || arr[end] == num) {
			System.out.println(1);
			return;
		}
		if(num < arr[mid]) {
			find(num, start, mid-1);
		} else {
			find(num, mid+1, end);
		}
	}

}
