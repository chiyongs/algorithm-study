package practice;

import java.util.*;

public class 토마토8_12 {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        arr = new int[N][M];

        int empty = 0;
        List<int[]> t = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    t.add(new int[]{i, j});
                } else if (arr[i][j] == -1) empty++;
            }
        }

        if (t.size() == N * M) {
            System.out.println(0);
            return;
        }

        int[][] dist = new int[N][M];

        Queue<int[]> q = new LinkedList<>();
        for (int[] loc : t) {
            q.offer(loc);
            dist[loc[0]][loc[1]] = 1;
        }

        int answer = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int dx = cur[0] + dir[d][0];
                int dy = cur[1] + dir[d][1];

                if (0 <= dx && dx < N && 0 <= dy && dy < M && arr[dx][dy] != -1 && dist[dx][dy] == 0) {
                    dist[dx][dy] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{dx, dy});
                    answer = Math.max(answer, dist[dx][dy]);
                }
            }
        }

        if (N*M - cnt == empty) System.out.println(answer - 1);
        else System.out.println(-1);
    }
}
