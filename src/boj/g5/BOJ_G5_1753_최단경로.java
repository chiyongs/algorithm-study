package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 25.
 * @see https://www.acmicpc.net/problem/1753
 * @performance 111016	592
 * @category #Dijkstra #인접리스트 #우선순위 큐
 * @note
 */
public class BOJ_G5_1753_최단경로 {
	
	static class Node implements Comparable<Node>{
		int vertex, cost, aCost;
		Node link;
		
		public Node (int vertex, int cost, Node link) {
			this.vertex = vertex;
			this.cost = cost;
			this.link = link;
		}
		
		public Node (int vertex, int aCost) {
			this.vertex = vertex;
			this.aCost = aCost;
		}

		@Override
		public int compareTo(Node o) {
			return this.aCost - o.aCost;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", cost=" + cost + ", aCost=" + aCost + ", link=" + link + "]";
		}

			
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		
		Node[] adjList = new Node[V+1];
		int start = Integer.parseInt(br.readLine());
		
		for(int e=0;e<E;e++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
		}		
		
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		pQ.offer(new Node(start, distance[start]));
		while(!pQ.isEmpty()) {
			Node current = pQ.poll();
			
			if(visited[current.vertex]) {
				continue;
			}
			
			visited[current.vertex] = true;
			
			for(Node temp = adjList[current.vertex]; temp != null; temp = temp.link) {
				// temp노드는 인접리스트에서 current.vertex와 인접한 노드이므로 인접했는지 검사안해도됨
				// temp.cost 가 current.vertex에서 temp.vertex로의 비용이다!!
				if(!visited[temp.vertex] && distance[temp.vertex] > distance[current.vertex] + temp.cost) {
					distance[temp.vertex] = distance[current.vertex] + temp.cost;
					pQ.offer(new Node(temp.vertex, distance[temp.vertex]));
				}
			}		
			
		}
		
		for(int i=1;i<=V;i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(distance[i]).append("\n");
			}
		}
		System.out.println(sb.toString());

	}

}
