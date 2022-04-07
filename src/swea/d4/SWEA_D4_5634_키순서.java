package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 4. 6.
 * @see 
 * @performance 94,996 kb 3,910 ms
 * @category #BFS #DFS #플루이드
 * @note 인접리스트
 */
public class SWEA_D4_5634_키순서 {
	
	static int N,M,graph[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			int answer = 0;
			graph = new int[N+1][N+1];
			for(int m=0;m<M;m++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1;
			}
			
			for(int i=1;i<=N;i++) {
				int big = getBigger(i, new boolean[N+1]);
				int small = getSmaller(i, new boolean[N+1]);

				if(big+small == N-1) {
					answer++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());

	}
	private static int getSmaller(int start, boolean[] visited) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(start);
		visited[start] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			
			for(int i=1;i<=N;i++) {
				if(graph[i][cur] == 1 && !visited[i]) {
					Q.offer(i);
					visited[i] = true;
				}
			}
		}
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(visited[i]) cnt++;
		}
		
		return cnt-1;
	}
	
	private static int getBigger(int start, boolean[] visited) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(start);
		visited[start] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			
			for(int i=1;i<=N;i++) {
				if(graph[cur][i] == 1 && !visited[i]) {
					Q.offer(i);
					visited[i] = true;
				}
			}
		}
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(visited[i]) cnt++;
		}
		
		return cnt-1;
	}
}
