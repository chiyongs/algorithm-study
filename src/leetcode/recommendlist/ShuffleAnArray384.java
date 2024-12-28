package leetcode.recommendlist;

public class ShuffleAnArray384 {
    class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] res = new int[nums.length];
            res = nums.clone();

            for (int i=0;i<nums.length;i++) {
                int random = (int) (Math.random() * (nums.length -i)) + i;
                swap(res, i, random);
            }
            return res;
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
