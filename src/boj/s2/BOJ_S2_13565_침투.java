package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 9.
 * @see https://www.acmicpc.net/problem/13565
 * @performance 44828	288
 * @category #BFS
 * @note
 */
public class BOJ_S2_13565_침투 {

    static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int M, N, map[][];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        percolate();

    }

    private static void percolate() {
        Queue<Point> Q = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        for(int i=0;i<N;i++) {
            if(map[0][i] == 0) {
                Q.offer(new Point(0,i));
                visited[0][i] = true;
            }
        }

        while(!Q.isEmpty()) {
            Point cur = Q.poll();

            if(cur.r == M-1) {
                System.out.println("YES");
                return;
            }

            for(int d=0;d<4;d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(nr < 0 || nc < 0 || nr >= M || nc >= N || map[nr][nc] == 1 || visited[nr][nc]) continue;

                Q.offer(new Point(nr,nc));
                visited[nr][nc] = true;
            }
        }

        System.out.println("NO");

    }
}
