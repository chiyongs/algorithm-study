package leetcode.recommendlist;

import java.util.*;

public class LongestHarmoniousSubsequence594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            int val = map.getOrDefault(num, 0) + 1;
            map.put(num, val);
        }

        int result = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key+1)) {
                int more = map.get(key) + map.getOrDefault(key + 1, 0);

                result = Math.max(result, more);
            }
        }
        return result;
    }
}
