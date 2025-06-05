package leetcode.recommendlist;

public class LeftAndRightSumDifferences2574 {
    public int[] leftRightDifference(int[] nums) {
        int len = nums.length;
        int leftSum = 0;
        int rightSum = 0;
        int[] right = new int[len];
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = leftSum;
            leftSum += nums[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            right[i] = rightSum;
            rightSum += nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = Math.abs(left[i] - right[i]);
        }
        return nums;
    }
}
