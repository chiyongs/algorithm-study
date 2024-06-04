package leetcode.recommendlist;

import java.util.*;

public class FourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length-3;i++) {
            if (i != 0 && nums[i-1] == nums[i]) continue;
            for(int j=i+1;j<nums.length-2;j++) {
                if (j != i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = nums.length - 1;

                while(k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];

                    if (sum == target) {
                        set.add(List.of(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
