package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 13.
 * @see https://www.acmicpc.net/problem/10816
 * @performance 180136	1216	
 * @category #이분탐색
 * @note
 */
public class BOJ_S4_10816_숫자카드2 {
	static int n, arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(findRight(target)-findLeft(target)).append(" ");
		}
		
		System.out.println(sb.toString());

	}

	private static int findLeft(int target) {
		int start = 0, end = n;
		while (start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] >= target)
				end = mid;
			else
				start = mid + 1;
		}
		return start;
	}

	private static int findRight(int target) {
		int start = 0, end = n;
		while (start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] > target)
				end = mid;
			else
				start = mid + 1;
		}
		return start;
	}

}
