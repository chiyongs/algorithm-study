package leetcode.recommendlist;

import java.util.Arrays;

public class CheckIfAllTheIntegersInARangeAreCovered1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        for (int[] range : ranges) {
            if (left >= range[0] && left <= range[1]) {
                left = range[1] + 1;
            }
        }
        return left > right;
    }
}
