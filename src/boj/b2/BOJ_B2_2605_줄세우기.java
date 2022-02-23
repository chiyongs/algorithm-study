package boj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 22.
 * @see https://www.acmicpc.net/problem/2605
 * @performance 11660	76
 * @category #리스트
 * @note
 */

public class BOJ_B2_2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
				
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {			
			int k = Integer.parseInt(st.nextToken());			
			list.add(i-k, i+1);
		}
		
		for(int i=0;i<n;i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb.toString());
		
	}	
}
