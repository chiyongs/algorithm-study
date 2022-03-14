package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 10.
 * @see https://www.acmicpc.net/problem/1759
 * @performance 11904	80
 * @category #조합
 * @note
 */
public class BOJ_G5_1759_암호만들기 {
	
	static int L,C;
	static char[] input, password;
	static List<String> passwords = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		input = new char[C];
		password = new char[L];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<C;i++) {
			input[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(input);
		combination(0, 0);
		StringBuilder sb = new StringBuilder();

		Collections.sort(passwords);
		for(String p : passwords) {
			sb.append(p).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == L) {
			int mo = 0;
			int ja = 0;
			for(int i=0;i<L;i++) {
				if(password[i] == 'a' ||
						password[i] == 'e' ||
						password[i] == 'i' ||
						password[i] == 'o' ||
						password[i] == 'u') {
					mo++;
				} else {
					ja++;
				}
			}
			
			String p = String.valueOf(password);			
			if(mo >=1 && ja >= 2 && !passwords.contains(p)) passwords.add(String.valueOf(password));
			return;
		}
		
		for(int i=start;i<C;i++) {
			password[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}

}
