package leetcode.recommendlist;

public class FindPivotIndex724 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = 0;

        for (int num : nums) {
            right += num;
        }

        for (int i=0;i<nums.length;i++) {
            right -= nums[i];
            if (right == left) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
