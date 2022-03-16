package boj.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 16.
 * @see https://www.acmicpc.net/problem/1009
 * @performance 13608	1024
 * @category #기본
 * @note 
 * 		 
 */
public class BOJ_B3_1009_분산처리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int result = 1;
			for(int i=0;i<b;i++) {
				result *= a;
				result = result % 10;
			}
			
			if(result == 0) {
				sb.append(10).append("\n");
			} else {				
				sb.append(result).append("\n");				
			}
		}
		
		System.out.println(sb.toString());

	}

}
