package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1987_알파벳 {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C, answer;
    static char[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[26];
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        answer = 1;
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt) {
        answer = Math.max(cnt, answer);
        visited[arr[x][y] - 'A'] = true;
        for (int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];

            if (0 <= dx && dx < R && 0 <= dy && dy < C && !visited[arr[dx][dy] - 'A']) {
                visited[arr[dx][dy] - 'A'] = true;
                dfs(dx, dy, cnt + 1);
                visited[arr[dx][dy] - 'A'] = false;
            }
        }
    }
}
