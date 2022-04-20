package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 20.
 * @see https://www.acmicpc.net/problem/1620
 * @performance 53912	444
 * @category #해시
 * @note Map보단 배열이 더 빠르니 배열 쓸 수 있으면 배열을 먼저 쓰자!
 */
public class BOJ_S4_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> map1 = new HashMap<>();
		String[] map2 = new String[N+1];
		for(int i=1;i<=N;i++) {
			String input = br.readLine();
			map1.put(input, i);
			map2[i] = input;
		}
		
		for(int i=0;i<M;i++) {
			String input = br.readLine();
			if(Character.isDigit(input.charAt(0))) {
				sb.append(map2[Integer.parseInt(input)]).append("\n");
			} else {
				sb.append(map1.get(input)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
