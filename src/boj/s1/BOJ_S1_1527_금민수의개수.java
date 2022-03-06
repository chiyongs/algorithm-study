package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 6.
 * @see https://www.acmicpc.net/problem/1527
 * @performance 11508	80
 * @category #재귀
 * @note
 */
public class BOJ_S1_1527_금민수의개수 {
	
	static int count,A,B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		dfs(4);
		dfs(7);
		System.out.println(count);	

	}
	
	private static void dfs(long number) {
		if(number > B) return;
		if(A <= number && number <=B) count++;
		
		dfs(number*10 + 4);
		dfs(number*10 + 7);
	}

}
