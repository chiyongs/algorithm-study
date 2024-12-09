package leetcode.recommendlist;

import java.util.*;

public class Permutations46 {
    List<List<Integer>> result;
    int[] numbers;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        numbers = new int[nums.length];
        result = new ArrayList<>();
        permutation(0, nums);
        return result;
    }

    void permutation(int cnt, int[] nums) {
        if (cnt == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<nums.length;i++) {
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
