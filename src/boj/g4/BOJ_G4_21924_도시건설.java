package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 13.
 * @see https://www.acmicpc.net/problem/21924
 * @performance 182492	1088
 * @category #크루스칼 #최소신장트리
 * @note 
 */
public class BOJ_G4_21924_도시건설 {
	
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Edge O) {
			return Integer.compare(this.cost, O.cost);
		}
	}

	static int N, parents[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Edge> edges = new ArrayList<>();
		
		long total = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			total += cost;
			edges.add(new Edge(from,to,cost));
		}
		
		
		Collections.sort(edges);
		
		makeSet();
		
		int cnt = 0;
		long spend = 0;
		for(Edge e : edges) {
			if(union(e.from, e.to)) {
				cnt++;
				spend += e.cost;
				if(cnt == N-1) break;
			}
		}
		
		int root = findParent(1);
		
		for(int i=2;i<=N;i++) {
			if(root != findParent(i)) {
				System.out.println("-1");
				return;
			}
		}
		
		System.out.println(total-spend);
		
	}
	
	private static void makeSet() {
		parents = new int[N+1];
		for(int i=1;i<=N;i++) {
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
	


}
