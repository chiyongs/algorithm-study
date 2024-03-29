package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 10.
 * @see https://www.acmicpc.net/problem/6603
 * @performance 12100	96
 * @category #조합
 * @note
 */
public class BOJ_S2_6603_로또 {
	
	static int K,input[],numbers[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str ="";		
		while(!(str = br.readLine()).equals("0")) {
			StringTokenizer st = new StringTokenizer(str," ");
			K = Integer.parseInt(st.nextToken());
			
			input = new int[K];
			numbers = new int[6];
			for(int i=0;i<K;i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void combination(int cnt, int start) {
		if(cnt == 6) {
			for(int i=0;i<6;i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<K;i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
}
