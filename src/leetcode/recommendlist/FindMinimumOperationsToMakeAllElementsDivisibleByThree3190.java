package leetcode.recommendlist;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree3190 {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }
}
