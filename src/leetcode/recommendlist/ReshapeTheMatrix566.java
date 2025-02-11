package leetcode.recommendlist;

public class ReshapeTheMatrix566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }

        int[][] reshape = new int[r][c];

        int i=0;
        int j=0;
        for (int[] row : mat) {
            for (int col : row) {
                reshape[i][j] = col;
                j++;
                if (j >= c) {
                    j = 0;
                    i++;
                }
            }
        }

        return reshape;
    }
}
