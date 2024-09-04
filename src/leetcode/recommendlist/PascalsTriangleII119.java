package leetcode.recommendlist;

import java.util.*;

public class PascalsTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        int[] arr = new int[rowIndex+1];
        arr[0] = 1;

        for (int i=1;i<=rowIndex;i++) {
            for (int j=i;j>0;j--) {
                arr[j] = arr[j] + arr[j-1];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int e : arr) {
            result.add(e);
        }
        return result;
    }
}
