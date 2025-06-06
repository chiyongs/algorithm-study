package leetcode.recommendlist;

public class ProjectionAreaOf3DShapes883 {
    public int projectionArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++){

            int max1 = -1, max2 = -1;

            for (int j=0; j<grid.length; j++){
                if(grid[i][j] > 0) sum++;
                if(grid[i][j] > max1) max1 = grid[i][j];
                if(grid[j][i] > max2) max2 = grid[j][i];
            }
            sum = sum + max1 + max2;
        }
        return sum;
    }
}
