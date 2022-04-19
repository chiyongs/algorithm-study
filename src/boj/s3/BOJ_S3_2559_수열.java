package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 19.
 * @see https://www.acmicpc.net/problem/2559
 * @performance 22316	192	
 * @category #투 포인터
 * @note 
 */
public class BOJ_S3_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = K-1;
		
		int result = 0;
		for(int i=start;i<=end;i++) {
			result += arr[i];
		}
		
		int answer = result;
		while(end < N-1) {
			result -= arr[start++];
			result += arr[++end];
			if(result > answer) answer = result;
		}
		
		System.out.println(answer);
	}

}
