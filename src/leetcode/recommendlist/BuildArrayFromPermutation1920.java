package leetcode.recommendlist;

public class BuildArrayFromPermutation1920 {
    public int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];

        for (int i=0;i<nums.length;i++) {
            arr[i] = nums[nums[i]];
        }

        return arr;
    }
}
