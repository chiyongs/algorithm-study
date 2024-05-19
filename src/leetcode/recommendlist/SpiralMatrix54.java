package leetcode.recommendlist;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        SpiralMatrix54 s = new SpiralMatrix54();
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        s.spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0;
        int bot = matrix.length - 1;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();
        while (left <= right && top <= bot) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bot; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (left <= right && top <= bot) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bot][i]);
                }
                bot--;
                for (int i = bot; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
