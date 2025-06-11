package leetcode.recommendlist;

import java.util.Collections;
import java.util.List;

public class CounPairsWhoseSumIsLessThanTarget2824 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);

        int left = 0;
        int right = nums.size()-1;

        int cnt = 0;

        while (left < right) {
            int leftNum = nums.get(left);
            int rightNum = nums.get(right);

            if (leftNum + rightNum >= target) {
                right--;
            } else {
                cnt += right - left;
                left++;
            }
        }
        return cnt;
    }
}
