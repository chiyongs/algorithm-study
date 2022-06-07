package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 12.
 * @see https://www.acmicpc.net/problem/3584
 * @performance 22440	208
 * @category #유니온파인드
 * @note 
 */
public class BOJ_G4_3584_가장가까운공통조상 {

	static int N, parents[];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			parents = new int[N+1];
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				parents[B] = A;
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int result = findNearSameParent(A,B);
			if(result == 0) {
				for(int i=1;i<=N;i++) {
					if(parents[i] == 0) {
						result = i;
						break;
					}
				}
			}
			sb.append(result).append("\n");
			
		}
		
		System.out.println(sb);

	}
	
	private static int findNearSameParent(int a, int b) {
		int aRoot = parents[a];
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(a, 0);
		int depth = 1;
		while(aRoot != 0) {
			aRoot = parents[aRoot];
			map.put(aRoot, depth++);
		}
		
		int bRoot = b;
		while(bRoot != 0) {
			if(map.containsKey(bRoot)) {
				return bRoot;
			} else {
				bRoot = parents[bRoot];
			}
			
		}
		
		return 0;
	}

}
