package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 4.
 * @see https://www.acmicpc.net/problem/11047
 * @performance 11524	72
 * @category #그리디
 * @note
 */
public class BOJ_S3_11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for(int i=0;i<n;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		
		int idx = n-1;
		while(k>0) {
			if(coins[idx] > k) idx--;
			if(coins[idx] == k) {
				answer++;
				k -= coins[idx];
			}
			if(coins[idx] < k) {
				answer += k / coins[idx];
				k = k - (k/coins[idx])*coins[idx];
			}
		}
		
		System.out.println(answer);

	}

}
