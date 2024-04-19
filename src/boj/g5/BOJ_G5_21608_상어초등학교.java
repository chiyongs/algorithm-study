package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G5_21608_상어초등학교 {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int[][] map;
    static Map<Integer, int[]> info;

    static class Seat implements Comparable<Seat> {
        int x, y, like, empty;

        Seat(int x, int y, int l, int e) {
            this.x = x;
            this.y = y;
            this.like = l;
            this.empty = e;

        }

        @Override
        public int compareTo(Seat o) {
            if (this.like == o.like) {
                if (this.empty == o.empty) {
                    if (this.x == o.x) {
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return o.empty - this.empty;
            }
            return o.like - this.like;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new HashMap<>();
        map = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());
            int[] list = new int[4];
            for (int k = 0; k < 4; k++) {
                list[k] = Integer.parseInt(st.nextToken());
            }
            info.put(no, list);
            find(no);
        }

        System.out.println(getSatisfactionSum());
    }

    static int getSatisfactionSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int stdNo = map[i][j];

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int dx = i + dir[d][0];
                    int dy = j + dir[d][1];

                    if (0 <= dx && dx < N && 0 <= dy && dy < N) {
                        int[] list = info.get(stdNo);
                        for (int l : list) {
                            if (l == map[dx][dy]) cnt++;
                        }
                    }
                }

                if (cnt == 0) sum += 0;
                else if (cnt == 1) sum += 1;
                else if (cnt == 2) sum += 10;
                else if (cnt == 3) sum += 100;
                else sum += 1000;
            }
        }
        return sum;
    }

    static void find(int no) {
        PriorityQueue<Seat> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    int[] likeAndEmpty = f(no, i, j);
                    pq.offer(new Seat(i, j, likeAndEmpty[0], likeAndEmpty[1]));
                }
            }
        }
        Seat best = pq.poll();
        map[best.x][best.y] = no;
    }

    static int[] f(int no, int x, int y) {
        int like = 0;
        int empty = 0;
        for (int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];

            if (0 <= dx && dx < N && 0 <= dy && dy < N) {
                if (map[dx][dy] == 0) empty++;
                else {
                    int[] list = info.get(no);
                    for (int l : list) {
                        if (l == map[dx][dy]) like++;
                    }
                }
            }
        }
        return new int[]{like, empty};
    }
}
