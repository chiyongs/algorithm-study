package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 4. 13. 2022.6.30
 * @see https://www.acmicpc.net/problem/1920
 * @performance 103268	2640 70980	1632 54044	516
 * @category #이분탐색
 * @note
 */
public class BOJ_S4_1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");

		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());

			int left = 0;
			int right = N-1;
			int mid = 0;

			boolean flag = false;
			while(left <= right) {
				mid = (left + right) / 2;

				if(arr[mid] < num) {
					left = mid + 1;
				} else if(arr[mid] > num) {
					right = mid - 1;
				} else {
					flag = true;
					break;
				}
			}

			if(flag) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}

		}

		System.out.println(sb);

	}

}
