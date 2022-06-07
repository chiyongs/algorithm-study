package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 12.
 * @see https://www.acmicpc.net/problem/1717
 * @performance 48636	364
 * @category #유니온파인드
 * @note 
 */
public class BOJ_G4_1717_집합의표현 {
	
	static int n,parents[];
	
	private static void makeSet() {
		parents = new int[n+1];
		for(int i=0;i<=n;i++) {
			parents[i] = i;
		}
	}
	
	private static int findParent(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findParent(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = findParent(a);
		int bRoot = findParent(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		makeSet();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(command == 0) {
				union(a,b);
			} else {
				int aRoot = findParent(a);
				int bRoot = findParent(b);
				
				if(aRoot == bRoot) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		
		System.out.println(sb);

	}

}
