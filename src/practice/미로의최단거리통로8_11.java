package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의최단거리통로8_11 {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[7][7];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        int cnt = 0;
        int l = 0;
        while (!q.isEmpty()) {
            l = q.size();
            for (int i = 0; i < l; i++) {
                int[] cur = q.poll();

                for (int d = 0; d < dir.length; d++) {
                    int dx = cur[0] + dir[d][0];
                    int dy = cur[1] + dir[d][1];

                    if (0 <= dx && dx < 7 && 0 <= dy && dy < 7 && arr[dx][dy] == 0 && !visited[dx][dy]) {
                        if (dx == 6 && dy == 6) {
                            System.out.println(cnt+1);
                            return;
                        }
                        visited[dx][dy] = true;
                        q.offer(new int[]{dx, dy});
                    }
                }
            }
            cnt++;
        }
        System.out.println(-1);
    }
}
