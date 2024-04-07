package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드8_13 {

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if (arr[i][j] == 1) {
                    answer++;
                    bfs(i,j,arr);
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(int x, int y, int[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        arr[x][y] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d=0;d<8;d++) {
                int curX = cur[0] + dir[d][0];
                int curY = cur[1] + dir[d][1];

                if (0 <= curX && curX < N && 0 <= curY && curY < N && arr[curX][curY] == 1) {
                    arr[curX][curY] = 0;
                    q.offer(new int[]{curX, curY});
                }
            }
        }
    }
}
