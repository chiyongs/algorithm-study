package leetcode.recommendlist;

import java.util.*;

public class SubsetII90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for(int size=0;size<=nums.length;size++)
            comb(result, new ArrayList<>(), nums, 0, 0, size);
        return new ArrayList<>(result);
    }

    void comb(Set<List<Integer>> result, List<Integer> tempList, int[] nums,
              int cnt, int start, int size) {
        if (cnt == size) {
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i=start;i<nums.length;i++) {
                tempList.add(nums[i]);
                comb(result, tempList, nums, cnt+1, i+1, size);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
