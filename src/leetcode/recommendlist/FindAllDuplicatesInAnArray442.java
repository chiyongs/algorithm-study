package leetcode.recommendlist;

import java.util.*;

public class FindAllDuplicatesInAnArray442 {
    public List<Integer> findDuplicates_sorting(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++) {
            int cur = nums[i];
            int next = nums[i+1];
            if (cur == next) {
                if (!result.contains(cur)) {
                    result.add(cur);
                }
            }
        }
        return result;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            int cur = Math.abs(nums[i]);

            if (nums[cur-1] < 0) {
                result.add(cur);
            }
            nums[cur-1] *= -1;
        }
        return result;
    }
}
