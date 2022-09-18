package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_1749_점수따먹기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int maxR = 0;
        int maxC = 0;
        int max = Integer.MIN_VALUE;
        int[][] map = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > max) {
                    max = map[i][j];
                    maxR = i;
                    maxC = j;
                }
            }
        }

        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {maxR,maxC});
        boolean[][] visited = new boolean[N][M];
        visited[maxR][maxC] = true;

        while(!Q.isEmpty()) {
            int[] cur = Q.poll();


        }

    }
}
