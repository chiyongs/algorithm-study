package leetcode.recommendlist;

import java.util.*;

public class CombinationSum39 {
    static Set<List<Integer>> result;

    public static void main(String[] args) {
        CombinationSum39 c = new CombinationSum39();
        System.out.println(Arrays.toString(c.combinationSum(new int[]{2, 3, 6, 7}, 7).toArray()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new HashSet<>();
        Arrays.sort(candidates);
//        comb(target, new ArrayList<>(), candidates, 0);
        comb(target, new ArrayList<>(), candidates, 0, 0);
        return new ArrayList<>(result);
    }

    public void comb(int target, List<Integer> list, int[] candidates, int sum) {
        if (sum == target) {
            Collections.sort(list);
            result.add(list);
        } else if (sum < target) {
            for(int i=0;i<candidates.length;i++) {
                if (sum + candidates[i] <= target) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(candidates[i]);
                    comb(target, temp, candidates, sum+candidates[i]);
                }
            }
        }
    }

    public void comb(int target, List<Integer> list, int[] candidates, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
        } else if (sum < target) {
            for(int i=start;i<candidates.length;i++) {
                if (sum + candidates[i] <= target) {
                    list.add(candidates[i]);
                    comb(target, list, candidates, sum+candidates[i], i);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
