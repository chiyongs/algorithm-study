package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 10. 11.
 * @see https://www.acmicpc.net/problem/2468
 * @performance 54060	276
 * @category #bfs
 * @note
 */
public class BOJ_S1_2468_안전영역 {

    static int N, map[][];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {
        int max = 0;
        for(int i=0;i<=100;i++) {
            boolean[][] visited = new boolean[N][N];

            Queue<int[]> Q = new LinkedList<>();
            int cnt = 0;
            for(int r=0;r<N;r++) {
                for(int c=0;c<N;c++) {
                    if(map[r][c] > i && !visited[r][c]) {
                        cnt++;
                        Q.offer(new int[]{r,c});
                        visited[r][c] = true;
                        while(!Q.isEmpty()) {
                            int[] cur = Q.poll();

                            for(int d=0;d<4;d++) {
                                int nr = cur[0] + dr[d];
                                int nc = cur[1] + dc[d];

                                if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] ||
                                map[nr][nc] <= i) continue;

                                visited[nr][nc] = true;
                                Q.offer(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }

            if(max < cnt) max = cnt;


        }

        return max;
    }
}
