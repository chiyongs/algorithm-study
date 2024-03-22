package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chiyongs
 * @performance 137840    544
 * @category #DFS #BFS
 * @note
 * @see <a href="https://www.acmicpc.net/problem/11724">...</a>
 * @since 2022. 6. 2.
 */
public class BOJ_S2_11724_연결요소의개수 {

    static List<List<Integer>> nodes;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int answer = 0;

        nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.get(a - 1).add(b - 1);
            nodes.get(b - 1).add(a - 1);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                answer++;
//                dfs(i);
                bfs(i);
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            List<Integer> list = nodes.get(cur);
            for (Integer n : list) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.offer(n);
                }
            }
        }
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        for (Integer n : nodes.get(cur)) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(n);
            }
        }
    }
}
