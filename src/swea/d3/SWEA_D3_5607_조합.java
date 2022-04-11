package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 11.
 * @see 
 * @performance 28,160 kb 138 ms
 * @category #재귀 #페르마 정리
 * @note 
 */
public class SWEA_D3_5607_조합 {
	
	private static final int MOD = 1234567891;
	private static long[] factorial;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer("");
		factorial = new long[1000001];
		factorial[0] = 1;
		for(int i=1;i<=1000000;i++) {
			factorial[i] = (i * factorial[i-1]) % MOD;
		}
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long answer = 0;
			answer = (factorial[N] * exp(factorial[N-R]*factorial[R] % MOD, MOD-2)) % MOD;
			System.out.printf("#%d %d\n",t,answer);
		}
	}
	
	private static long exp(long l, int exp_num) {
		if(exp_num == 1) return l % MOD;
		long val = exp(l, exp_num/2);
		val = val * val % MOD;
		if(exp_num%2 == 0) return val;
		return val*l % MOD;
	}

}
