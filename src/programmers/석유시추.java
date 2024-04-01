package programmers;

import java.util.*;

public class 석유시추 {

    static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};

    public int solution(int[][] land) {
        int answer = 0;

        int row = land.length;
        int col = land[0].length;

        boolean[][] visited = new boolean[row][col];
        int[] answers = new int[col];
        for(int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (visited[i][j] || land[i][j] == 0) continue;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i,j});
                visited[i][j] = true;

                int a = 1;
                int l = j;
                int r = j;
                while(!q.isEmpty()) {
                    int[] cur = q.poll();

                    for(int d=0;d<4;d++) {
                        int dx = dir[d][0];
                        int dy = dir[d][1];

                        int curx = cur[0] + dx;
                        int cury = cur[1] + dy;
                        if (0<=curx && curx < row && 0<= cury && cury < col
                                && !visited[curx][cury] && land[curx][cury] == 1) {
                            visited[curx][cury] = true;
                            q.offer(new int[]{curx, cury});
                            a++;
                            l = Math.min(l, cury);
                            r = Math.max(r, cury);
                        }
                    }
                }

                for(int c = 0;c<col;c++) {
                    if (l <= c && c <= r) {
                        answers[c] += a;
                        answer = Math.max(answer, answers[c]);
                    }
                }
            }
        }

        return answer;
    }
}
