package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author chiyongs
 * @since 2022. 3. 7.
 * @see https://www.acmicpc.net/problem/1182
 * @performance 11748	96
 * @category #부분집합
 * @note
 */
public class BOJ_S2_1182_부분수열의합 {
	
	static int N,S,arr[],answer;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		subSet(0,0);
		System.out.println(S == 0 ? answer-1 : answer);		

	}
	
	private static void subSet(int cnt, int sum) {
		if(cnt == N) {
			if(sum == S) {
				answer++;
			}
			return;
		}
		
		isSelected[cnt] = true;
		subSet(cnt+1, sum+arr[cnt]);
		isSelected[cnt] = false;
		subSet(cnt+1, sum);		
	}

}
