package leetcode.recommendlist;

public class LargestNumberAtLeastTwiceOfOthers747 {
    public int dominantIndex(int[] nums) {
        int index = 0;
        int max = 0;

        for (int i=0;i<nums.length;i++) {
            int num = nums[i];

            if (num > max) {
                if (num >= (max * 2)) {
                    index = i;
                } else {
                    index = -1;
                }
                max = num;
            } else if (num < max) {
                if (num * 2 > max) {
                    return -1;
                }
            }
        }
        return index;
    }
}
