package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_S3_16956_늑대와양 {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];
        List<int[]> sheeps = new ArrayList<>();
        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<C;j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'S') sheeps.add(new int[]{i,j});
            }
        }

        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        for(int[] sheep : sheeps) {
            q.offer(sheep);
            visited[sheep[0]][sheep[1]] = true;
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d=0;d<4;d++) {
                int dx = cur[0] + dir[d][0];
                int dy = cur[1] + dir[d][1];

                if (0<=dx && 0<=dy && dx<R && dy<C && !visited[dx][dy]) {
                    if (arr[dx][dy] == 'W') {
                        System.out.println(0);
                        return;
                    } else if (arr[dx][dy] == '.') {
                        visited[dx][dy] = true;
                        arr[dx][dy] = 'D';
                    }
                }
            }
        }

        System.out.println(1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
