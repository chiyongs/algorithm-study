package leetcode.recommendlist;

public class SortArrayByParityII922 {
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;

        while (even < nums.length && odd < nums.length) {
            if (nums[even] %2 != 0) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;

                odd += 2 ;
            } else {
                even += 2 ;
            }
        }

        return nums;
    }
}
