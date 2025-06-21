package leetcode.recommendlist;

public class MinimumOperationsToMakeArraySumDivisibleByK3512 {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
