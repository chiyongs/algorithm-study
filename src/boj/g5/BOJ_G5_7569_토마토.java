package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chiyongs
 * @since 2022. 6. 8.
 * @see https://www.acmicpc.net/problem/7569
 * @performance 127148	664
 * @category #BFS #DFS
 * @note
 */
public class BOJ_G5_7569_토마토 {

    static class Tomato {
        int r,c,h;

        public Tomato(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

        @Override
        public String toString() {
            return "Tomato{" +
                    "r=" + r +
                    ", c=" + c +
                    ", h=" + h +
                    '}';
        }
    }

    static int N,M,H,map[][][],distance[][][],answer,zero_cnt;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<Tomato> tomatoList;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        tomatoList = new ArrayList<>();
        answer = 0;
        zero_cnt = 0;
        for(int h=0;h<H;h++) {
            for(int n=0;n<N;n++) {
                st = new StringTokenizer(br.readLine());
                for(int m=0;m<M;m++) {
                    int val = Integer.parseInt(st.nextToken());
                    if(val == 1) tomatoList.add(new Tomato(n,m,h));
                    else if(val == 0) zero_cnt++;
                    map[n][m][h] = val;
                }
            }
        }

        bfs();

        if(zero_cnt == 0) System.out.println(0);
        else {
            if(flag) System.out.println(answer-1);
            else System.out.println(-1);
        }

    }

    static void bfs() {
        Queue<Tomato> Q = new LinkedList<>();
        distance = new int[N][M][H];

        for(Tomato t: tomatoList) {
            Q.offer(t);
            distance[t.r][t.c][t.h] = 1;
        }
        int cnt = 0;
        while(!Q.isEmpty()) {
            Tomato cur = Q.poll();

            if(answer < distance[cur.r][cur.c][cur.h]) answer = distance[cur.r][cur.c][cur.h];

            for(int d=0;d<4;d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc][cur.h] != 0 || distance[nr][nc][cur.h] != 0) continue;

                Q.offer(new Tomato(nr,nc,cur.h));
                map[nr][nc][cur.h] = 1;
                distance[nr][nc][cur.h] = distance[cur.r][cur.c][cur.h]+1;
                cnt++;
            }

            int nh = cur.h + 1;
            if(nh < H && map[cur.r][cur.c][nh] == 0 && distance[cur.r][cur.c][nh] == 0) {
                Q.offer(new Tomato(cur.r,cur.c,nh));
                distance[cur.r][cur.c][nh] = distance[cur.r][cur.c][cur.h]+1;
                map[cur.r][cur.c][nh] = 1;
                cnt++;
            }
            nh = cur.h - 1;
            if(nh >= 0 && map[cur.r][cur.c][nh] == 0 && distance[cur.r][cur.c][nh] == 0) {
                Q.offer(new Tomato(cur.r,cur.c,nh));
                distance[cur.r][cur.c][nh] = distance[cur.r][cur.c][cur.h]+1;
                map[cur.r][cur.c][nh] = 1;
                cnt++;
            }
        }

        if(cnt == zero_cnt) flag = true;
        else flag = false;
    }
}
