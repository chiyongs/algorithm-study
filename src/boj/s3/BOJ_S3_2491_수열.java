package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 24.
 * @see https://www.acmicpc.net/problem/2491
 * @performance 21384	192
 * @category #구현#IM대비문제!
 * @note
 */

public class BOJ_S3_2491_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int upCnt = 1, downCnt = 1;
		int upMax = 1, downMax = 1;
		for(int i=0;i<N-1;i++) {
			if(arr[i] <= arr[i+1]) {
				upCnt++;
				if(upCnt > upMax) {
					upMax = upCnt;
				}
			} else {
				upCnt = 1;
			}
		}
		for(int i=0;i<N-1;i++) {
			if(arr[i] >= arr[i+1]) {
				downCnt++;
				if(downCnt > downMax) {
					downMax = downCnt;
				}
			} else {
				downCnt = 1;
			}
		}
		
		System.out.println((upMax > downMax ? upMax : downMax));
	}

}
