package leetcode.recommendlist;

public class IslandPerimeter463 {
    int[] dirX = {-1,1,0,0};
    int[] dirY = {0,0,-1,1};
    int row;
    int col;

    public int islandPerimeter(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        int result = 0;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == 1) {
                    result += countPerimeters(grid, i, j);
                }
            }
        }
        return result;
    }

    private int countPerimeters(int[][] grid, int i, int j) {
        int perimeter = 0;
        for (int d=0;d<4;d++) {
            int dx = dirX[d] + i;
            int dy = dirY[d] + j;
            if (0 <= dx && dx < row && 0 <= dy && dy < col) {
                if (grid[dx][dy] == 0) {
                    perimeter++;
                }
            } else {
                perimeter++;
            }
        }
        return perimeter;
    }
}
