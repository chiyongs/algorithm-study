package leetcode.recommendlist;

public class HowManyNumbersAreSmallerThanTheCurrentNumber1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = cnt[nums[i] - 1];
            }
        }
        return result;
    }
}
