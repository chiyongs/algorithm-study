package boj.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 11.
 * @see https://www.acmicpc.net/problem/11401
 * @performance 43180	136
 * @category #페르마의 정리
 * @note
 */
public class BOJ_G1_11401_이항계수3 {
	
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] factorial = new long[4000001];
		factorial[0] = 1;
		for(int i=1;i<=4000000;i++) {
			factorial[i] = (i*factorial[i-1]) % MOD;
		}
		
		long result = (factorial[N] * pow((factorial[N-K]*factorial[K])%MOD,MOD-2)) % MOD;
		
		System.out.println(result);
		
	}
	
	private static long pow(long a, long b) {
		if(b == 1) return a % MOD;
		long val = pow(a, b/2);
		val = val * val % MOD;
		if(b%2 == 0) return val;
		else return (val * a) % MOD;
	}

}
