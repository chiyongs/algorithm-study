package leetcode.recommendlist;

public class HouseRobber198 {

    public int rob_useDp(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i=2;i<nums.length;i++) {
            dp[i] = Math.max((nums[i] + dp[i-2]), dp[i-1]);
        }

        return dp[nums.length-1];
    }


    public int rob_useRecursive(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(nums, i-2) + nums[i], rob(nums, i-1));
    }
}
