package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2024. 3. 21.
 * @see https://www.acmicpc.net/problem/2606
 * @performance 11632	80
 * @category #DFS #BFS
 * @note 
 * 		 
 */
public class BOJ_S3_2606_바이러스 {

	static int n;
	static boolean[] visited;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		arr = new int[n+1][n+1];
		for (int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		visited = new boolean[n+1];
		visited[1] = true;

		dfs(1);
		int answer = 0;
		for (int i=2;i<=n;i++) {
			if (visited[i]) answer++;
		}
		System.out.println(answer);
	}

	public static void dfs(int node) {
		for (int i=1;i<=n;i++) {
			if (i != node && arr[node][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

}
