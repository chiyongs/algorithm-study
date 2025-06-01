package leetcode.recommendlist;

public class ShuffleTheArray1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        int idx = 0;
        for (int i=0;i<nums.length/2;i++) {
            result[idx] = nums[i];
            idx+=2;
        }
        idx = 1;
        for (int j=nums.length/2;j<nums.length;j++) {
            result[idx] = nums[j];
            idx+=2;
        }

        return result;
    }
}
