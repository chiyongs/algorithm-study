package practice;

import java.util.Scanner;

public class 미로탐색8_10 {

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] arr;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[7][7];

        for(int i=0;i<7;i++) {
            for(int j=0;j<7;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[7][7];
        visited[0][0] = true;
        dfs(0,0, visited);
        System.out.println(answer);
    }

    static void dfs(int x, int y, boolean[][] visited) {
        if (x == 6 && y == 6) {
            answer++;
        } else {
            for(int d=0;d<4;d++) {
                int dx = x + dir[d][0];
                int dy = y + dir[d][1];

                if (0<=dx && dx < 7 && 0<=dy && dy < 7 && arr[dx][dy] == 0 && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    dfs(dx, dy, visited);
                    visited[dx][dy] = false;
                }
            }
        }
    }
}
