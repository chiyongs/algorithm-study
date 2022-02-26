package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 2. 26.
 * @see https://www.acmicpc.net/problem/2941
 * @performance 11648	92
 * @category #문자열
 * @note
 */
public class BOJ_S5_2941_크로아티아알파벳 {
	
	static String input;
	static String[] conditions = {"c=","c-","dz=","d-","lj","nj","s=","z="};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		for(int i=0,size=conditions.length;i<size;i++) {
			if(input.contains(conditions[i])) {
				input = input.replace(conditions[i], "a");
			}
		}
		System.out.println(input.length());
	}
}
