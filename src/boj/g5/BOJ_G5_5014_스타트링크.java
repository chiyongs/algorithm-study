package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 28.
 * @see https://www.acmicpc.net/problem/5014
 * @performance 55172	208
 * @category #BFS
 * @note
 */
public class BOJ_G5_5014_스타트링크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] visited = new int[F + 1];
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(S);
		visited[S] = 1;

		while (!Q.isEmpty()) {
			int cur = Q.poll();
			if (cur == G)
				break;

			if (cur + U <= F && visited[cur + U] == 0) {
				Q.offer(cur + U);
				visited[cur + U] = visited[cur] + 1;
			}

			if (cur - D >= 1 && visited[cur - D] == 0) {	
				Q.offer(cur - D);
				visited[cur - D] = visited[cur] + 1;
			}

		}
		
		if (visited[G] != 0)
			System.out.println(visited[G] - 1);
		else
			System.out.println("use the stairs");

	}
}
