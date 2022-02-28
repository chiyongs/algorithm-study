package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 2. 28.
 * @see https://www.acmicpc.net/problem/1629
 * @performance 11548	88
 * @category #재귀
 * @note
 */
public class BOJ_S1_1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		
		long result = calculate(a,b,c);
		System.out.println(result);
	}
	
	private static long calculate(long a, long b, long c) {
		if(b == 1) {			
			return a % c;
		}
		long val = calculate(a,b/2,c);		
		val = val * val % c;
		if(b % 2 == 0) {
			return val;
		} else {
			return val * a % c;
		}
	}

}

