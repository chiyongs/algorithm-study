package leetcode.recommendlist;

public class SmallestRangeI908 {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int result = (max - k) - (min + k);
        return result > 0 ? result : 0;
    }
}
