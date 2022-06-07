package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 2.
 * @see https://www.acmicpc.net/problem/11724
 * @performance 137840	544
 * @category #DFS #BFS
 * @note 
 * 		 
 */
public class BOJ_S2_11724_연결요소의개수 {
	
	static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		
	}
	
	static Node[] nodes;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodes = new Node[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a] = new Node(b,nodes[a]);
			nodes[b] = new Node(a,nodes[b]);
		}
		
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(visited[i]) continue;
			cnt++;
			dfs(i);
		}
		
		System.out.println(cnt);

	}
	
	static void dfs(int num) {
		visited[num] = true;
		
		for(Node temp = nodes[num];temp!=null;temp=temp.link) {
			if(visited[temp.vertex]) continue;
			
			visited[temp.vertex] = true;
			dfs(temp.vertex);
		}
	}

}
