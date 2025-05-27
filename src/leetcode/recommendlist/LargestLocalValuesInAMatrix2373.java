package leetcode.recommendlist;

public class LargestLocalValuesInAMatrix2373 {
    public int[][] largestLocal(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] result = new int[rows - 2][cols - 2];

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                result[row][col] = findLargest(grid, row, col);
            }
        }

        return result;
    }

    private int findLargest(int[][] grid, int row, int col) {
        int result = grid[row][col];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                result = Math.max(result, grid[i][j]);
            }
        }
        return result;
    }

}
