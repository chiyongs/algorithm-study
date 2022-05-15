package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 5. 15.
 * @see https://www.acmicpc.net/problem/1316
 * @performance 11504	76
 * @category #문자열
 * @note 
 */
public class BOJ_S5_1316_그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=0;i<N;i++) {
			char[] word = br.readLine().toCharArray();
			
			int[] alphabets = new int[26];
			boolean flag = false;
			for(int j=0;j<word.length;j++) {
				if(alphabets[word[j]-'a'] == 0) alphabets[word[j]-'a']++;
				else {
					if(word[j-1] != word[j]) {
						flag = true;
						break;
					}
				}
			}
			
			if(!flag) answer++; 
		}
		
		System.out.println(answer);

	}

}
