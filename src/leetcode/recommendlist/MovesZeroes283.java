package leetcode.recommendlist;

public class MovesZeroes283 {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            if (num != 0) {
                nums[idx++] = num;
            }
        }

        while (idx < nums.length) {
            nums[idx++] = 0;
        }

    }
}
