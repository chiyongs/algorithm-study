package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chiyongs
 * @since 2022. 6. 23.
 * @see https://www.acmicpc.net/problem/16234
 * @performance 295428	628
 * @category #구현
 * @note
 */
public class BOJ_G5_16234_인구이동 {

    static boolean[][] visited;
    static int[][] map;
    static int N, L, R,openCountry;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            visited = new boolean[N][N];
            openCountry = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j]) continue;
                    list = new ArrayList<>();
                    int temp = open(i,j);

                    if(list.size() == 1) continue;
                    for(int[] coord : list) {
                        map[coord[0]][coord[1]] = temp;
                    }

                }
            }

            if(openCountry == 0) break;
            answer++;
        }

        System.out.println(answer);
    }

    static int open(int r,int c) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{r,c});
        visited[r][c] = true;
        list.add(new int[]{r,c});

        int cnt = 1;
        int sum = map[r][c];
        while(!Q.isEmpty()) {
            int[] cur = Q.poll();

            for(int d=0;d<4;d++) {
                int nr = dr[d] + cur[0];
                int nc = dc[d] + cur[1];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;

                int diff = Math.abs(map[cur[0]][cur[1]] - map[nr][nc]);
                if(diff >= L && diff <= R) {
                    Q.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    cnt++;
                    sum += map[nr][nc];
                    list.add(new int[]{nr,nc});
                    openCountry++;
                }
            }
        }

        return sum / cnt;
    }


}
