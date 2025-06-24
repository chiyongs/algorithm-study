package leetcode.recommendlist;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayInTheGivenOrder1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>(nums.length);
        int idx = 0;
        for (int num : nums) {
            target.add(index[idx++], num);
        }
        int[] result = new int[target.size()];
        int i = 0;
        for (int num : target) {
            result[i++] = num;
        }
        return result;
    }
}
