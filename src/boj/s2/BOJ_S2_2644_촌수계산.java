package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 7.
 * @see https://www.acmicpc.net/problem/2644
 * @performance 11576	76
 * @category #BFS #DFS
 * @note
 */
public class BOJ_S2_2644_촌수계산 {

    static int[][] graph;
    static int answer,b,n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        graph = new int[n+1][n+1];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(a,0);

        System.out.println(answer != 0 ? answer : -1);

    }

    private static void dfs(int cur, int cnt) {
        if(cur == b) {
            answer = cnt;
            return;
        }
        visited[cur] = true;

        for(int i=1;i<=n;i++) {
            if(!visited[i] && graph[cur][i] == 1) {
                dfs(i,cnt+1);
            }
        }
    }
}
