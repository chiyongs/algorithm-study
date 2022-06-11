package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chiyongs
 * @since 2022. 6. 11.
 * @see https://www.acmicpc.net/problem/18428
 * @performance 17856	148
 * @category #백트래킹 #BFS
 * @note
 */
public class BOJ_S1_18428_감시피하기 {

    static int N,student_cnt;
    static char map[][];
    static List<int[]> teachers;
    static List<int[]> points;
    static int[][] selected;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        teachers = new ArrayList<>();
        points = new ArrayList<>();
        selected = new int[3][2];
        map = new char[N][N];
        student_cnt = 0;

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                char c = st.nextToken().charAt(0);

                if(c == 'T') teachers.add(new int[] {i,j});
                else if(c == 'S') student_cnt++;
                else points.add(new int[] {i,j});
                map[i][j] = c;
            }
        }

        choose(0,0);
        System.out.println("NO");

    }

    static void choose(int cnt, int start) {
        if(cnt == 3) {
            char[][] temp = new char[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    temp[i][j] = map[i][j];
                }
            }

            for(int i=0;i<3;i++) {
                temp[selected[i][0]][selected[i][1]] = 'O';
            }

            boolean result = bfs(temp);

            if(result) {
                System.out.println("YES");
                System.exit(0);
            }

            return;
        }

        for(int i=start,size=points.size();i<size;i++) {
            selected[cnt][0] = points.get(i)[0];
            selected[cnt][1] = points.get(i)[1];
            choose(cnt+1, i+1);
        }
    }


    static boolean bfs(char[][] map) {
        Queue<int[]> Q = new LinkedList<>();
        for(int[] teacher : teachers) {
            Q.offer(teacher);
        }
        int cnt = 0;
        while(!Q.isEmpty()) {
            int[] cur = Q.poll();

            for(int d=0;d<4;d++) {
                int nr = cur[0];
                int nc = cur[1];
                while(true) {
                    nr += dr[d];
                    nc += dc[d];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 'O') break;

                    if(map[nr][nc] == 'S') cnt++;
                }
            }

        }

        if(cnt == 0) return true;
        else return false;
    }
}
