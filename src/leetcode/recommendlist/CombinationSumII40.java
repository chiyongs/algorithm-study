package leetcode.recommendlist;

import java.util.*;

public class CombinationSumII40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    void backtrack(List<List<Integer>> result, int[] candidates, int remain, int start, List<Integer> list) {
        if (remain == 0) {
            result.add(new ArrayList<>(list));
        } else if (remain > 0) {
            for(int i=start;i<candidates.length;i++) {
                if (i > start && candidates[i] == candidates[i-1]) continue;
                list.add(candidates[i]);
                backtrack(result, candidates, remain-candidates[i], i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
