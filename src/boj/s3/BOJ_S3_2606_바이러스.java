package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2606_바이러스 {
	
	static int[][] graphs;
	static int V,E,cnt;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		graphs = new int[V+1][V+1];
		visited = new boolean[V+1];
		
		for(int i=0;i<E;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graphs[a][b] = 1;
			graphs[b][a] = 1;
		}
		
		cnt = 0;
		dfs(1);
		
		System.out.println(cnt);

	}
	
	static void dfs(int a) {
		visited[a] = true;
		
		for(int i=1;i<=V;i++) {
			if(!visited[i] && graphs[a][i]==1) {
				cnt++;
				dfs(i);
			}						
		}
	}

}
