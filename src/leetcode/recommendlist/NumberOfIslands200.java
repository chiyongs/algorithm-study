package leetcode.recommendlist;

import java.util.*;

public class NumberOfIslands200 {
    boolean[][] visited;
    int row, col;
    int[] dirx = {-1,1,0,0};
    int[] diry = {0,0,-1,1};

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;

        visited = new boolean[row][col];

        int numIslands = 0;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                char point = grid[i][j];
                if (point == '1' && !visited[i][j]) {
                    numIslands++;

                    bfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    void bfs(char[][] grid, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d<4;d++) {
                int dx = cur[0] + dirx[d];
                int dy = cur[1] + diry[d];

                if (0 <= dx && dx < row && 0 <= dy && dy < col
                        && !visited[dx][dy] && grid[dx][dy] == '1') {
                    q.offer(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }
        }
    }
}
