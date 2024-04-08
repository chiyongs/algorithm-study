package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_S1_2583_영역구하기 {

    static int N,M,K;
    static int[][] arr;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[M][N];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for(int x=x1;x<x2 && x <M;x++) {
                for(int y=y1;y<y2 && y < N;y++) {
                    arr[x][y] = 1;
                }
            }
        }

        List<Integer> sizes = new ArrayList<>();
        int cnt = 0;
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                    sizes.add(bfs(i,j));
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(sizes);
        for(int s : sizes) {
            System.out.print(s + " ");
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        arr[x][y] = 1;
        int size = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d=0;d<dir.length;d++) {
                int curX = cur[0] + dir[d][0];
                int curY = cur[1] + dir[d][1];

                if(0<=curX && curX<M && 0<=curY && curY <N && arr[curX][curY] == 0) {
                    arr[curX][curY] = 1;
                    q.offer(new int[]{curX,curY});
                    size++;
                }
            }
        }
        return size;
    }
}
