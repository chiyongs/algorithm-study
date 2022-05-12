package boj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 5. 12.
 * @see https://www.acmicpc.net/problem/11720
 * @performance 11508	76
 * @category #문자열
 * @note 
 */
public class BOJ_B2_11720_숫자의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		
		int result = 0;
		for(int i=0;i<N;i++) {
			result += ch[i] - '0';
		}
		
		System.out.println(result);

	}

}
