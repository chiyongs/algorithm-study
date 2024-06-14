package leetcode.recommendlist;

import java.util.*;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<=nums.length;i++) {
            comb(result, new ArrayList<>(), nums, i, 0, 0);
        }
        return result;
    }

    void comb(List<List<Integer>> result, List<Integer> tempList, int[] nums, int require, int cnt, int start) {
        if (cnt == require) {
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i=start;i<nums.length;i++) {
                tempList.add(nums[i]);
                comb(result, tempList, nums, require, cnt+1, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
