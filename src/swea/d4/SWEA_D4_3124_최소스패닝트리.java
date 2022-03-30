package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 3. 30.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb
 * @performance 229,508 kb 3,102 ms
 * @category #MST #PRIM
 * @note 인접리스트
 */
public class SWEA_D4_3124_최소스패닝트리 {
	
	static class Node implements Comparable<Node>{
		int no;
		int cost;
		
		public Node(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return (this.cost - o.cost);
		}
	}
	
	static List<Node>[] graph;
	static int V,E;
	static long answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V+1];
			
			for(int i=1;i<=V;i++) {
				graph[i] = new ArrayList<Node>();
			}
			
			for(int e=0;e<E;e++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				graph[a].add(new Node(b,c));
				graph[b].add(new Node(a,c));				
			}
			
			prim();
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	private static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		visited[1] = true;
		
		for(Node i : graph[1]) {
			pq.offer(i);
		}
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.no]) continue;
			
			cnt++;
			answer += cur.cost;
			visited[cur.no]= true; 
			
			if(cnt == V-1) break;
			
			for(Node i: graph[cur.no]) {
				if(visited[i.no]) continue;
				pq.add(i);
			}
		}
		
	}

}
