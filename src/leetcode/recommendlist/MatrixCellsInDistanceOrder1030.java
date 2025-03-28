package leetcode.recommendlist;

import java.util.Arrays;

public class MatrixCellsInDistanceOrder1030 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] allCells = new int[rows*cols][2];

        int idx = 0;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                allCells[idx][0] = i;
                allCells[idx][1] = j;
                idx++;
            }
        }

        Arrays.sort(allCells, (o1, o2) -> Math.abs(o1[0] - rCenter) + Math.abs(o1[1] - cCenter) - Math.abs(o2[0] - rCenter) - Math.abs(o2[1] - cCenter));

        return allCells;
    }
}
