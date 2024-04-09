package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_6593_상범빌딩 {

    static int[] dirX = {-1,1,0,0,0,0};
    static int[] dirY = {0,0,-1,1,0,0};
    static int[] dirZ = {0,0,0,0,-1,1};

    static int L,R,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] map = new char[R][C][L];
            int[] start = new int[3];

            for(int k=0;k<L;k++) {
                for(int i=0;i<R;i++) {
                    String str = br.readLine();
                    for(int j=0;j<C;j++) {
                        map[i][j][k] = str.charAt(j);
                        if (map[i][j][k] == 'S') start = new int[]{i,j,k};
                    }
                }
                br.readLine();
            }

            int[][][] distance = new int[R][C][L];
            Queue<int[]> q = new LinkedList<>();
            q.offer(start);
            distance[start[0]][start[1]][start[2]] = 1;
            int minute = 0;
            while(!q.isEmpty()) {
                int[] cur = q.poll();

                for(int d=0;d<6;d++) {
                    int dx = cur[0] + dirX[d];
                    int dy = cur[1] + dirY[d];
                    int dz = cur[2] + dirZ[d];

                    if (0 <= dx && dx < R && 0 <= dy && dy < C && 0 <= dz && dz < L && distance[dx][dy][dz] == 0 && map[dx][dy][dz] != '#') {
                        if (map[dx][dy][dz] == 'E') {
                            minute = distance[cur[0]][cur[1]][cur[2]];
                            break;
                        }
                        distance[dx][dy][dz] = distance[cur[0]][cur[1]][cur[2]] + 1;
                        q.offer(new int[]{dx,dy,dz});
                    }
                }
            }
            if (minute == 0) System.out.println("Trapped!");
            else System.out.println("Escaped in " + minute + " minute(s).");
        }

    }
}
