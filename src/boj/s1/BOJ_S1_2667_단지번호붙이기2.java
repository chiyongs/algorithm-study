package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_S1_2667_단지번호붙이기2 {

    static int N, arr[][];
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                char ch = str.charAt(j);
                if (ch == '0') arr[i][j] = 0;
                else arr[i][j] = 1;
            }
        }

        int cnt = 0;
        List<Integer> sizes = new ArrayList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                    int size = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    arr[i][j] = 0;
                    size = 1;
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        for(int d=0;d<4;d++) {
                            int dx = cur[0] + dir[d][0];
                            int dy = cur[1] + dir[d][1];

                            if (0 <= dx && dx < N && 0 <= dy && dy < N && arr[dx][dy] == 1) {
                                size++;
                                q.offer(new int[]{dx,dy});
                                arr[dx][dy] = 0;
                            }
                        }
                    }
                    sizes.add(size);
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(sizes);
        for(int s : sizes) {
            System.out.println(s);
        }
    }
}
