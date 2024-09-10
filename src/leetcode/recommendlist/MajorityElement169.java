package leetcode.recommendlist;

import java.util.*;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
