package leetcode.recommendlist;

import java.util.*;

public class PermutationII47 {
    int[] numbers;
    boolean[] visited;
    Set<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new HashSet<>();
        visited = new boolean[nums.length];
        numbers = new int[nums.length];
        permutation(0, nums);
        List<List<Integer>> listlist = new ArrayList<>();
        for (List<Integer> e : result) {
            listlist.add(e);
        }
        return listlist;
    }

    void permutation(int cnt, int[] nums) {
        if (cnt == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<numbers.length;i++) {
                list.add(numbers[i]);
            }
            result.add(list);
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[cnt] = nums[i];
                permutation(cnt+1, nums);
                visited[i] = false;
            }
        }
    }
}
