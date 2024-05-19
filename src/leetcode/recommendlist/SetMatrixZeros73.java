package leetcode.recommendlist;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeros73 {
    public void setZeroes(int[][] matrix) {
        List<int[]> coords = new ArrayList<>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    coords.add(new int[]{i,j});
                }
            }
        }

        for(int[] coord : coords) {
            for(int i=0;i<matrix.length;i++) {
                matrix[i][coord[1]] = 0;
            }
            for(int j=0;j<matrix[0].length;j++) {
                matrix[coord[0]][j] = 0;
            }
        }
    }
}
