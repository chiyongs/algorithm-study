package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author chiyongs
 * @since 2022. 5. 13.
 * @see https://www.acmicpc.net/problem/1764
 * @performance 25716	268
 * @category #맵
 * @note 
 */
public class BOJ_S4_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		TreeSet<String> tset = new TreeSet<>();
		
		for(int i=0;i<N;i++) {
			tset.add(br.readLine());
		}
		
		int cnt = 0;
		TreeSet<String> result = new TreeSet<>();
		for(int i=0;i<M;i++) {
			String input = br.readLine();
			if(tset.contains(input)) {
				cnt++;
				result.add(input);
			}			
		}
		System.out.println(cnt);
		for(String s : result) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);

	}

}
