package leetcode.recommendlist;

import java.util.*;

public class LuckyNumbersInAMatrix1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<int[]> candidates = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            int min = Integer.MAX_VALUE;
            int colIdx = 0;
            for (int j = 0; j < col; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    colIdx = j;
                }
            }
            candidates.add(new int[]{min, colIdx});
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < candidates.size(); i++) {
            int[] candidate = candidates.get(i);
            int max = 0;
            int colIdx = candidate[1];
            for (int j = 0; j < row; j++) {
                max = Math.max(max, matrix[j][colIdx]);
            }
            if (max == candidate[0]) {
                result.add(max);
            }

        }

        return result;
    }
}
