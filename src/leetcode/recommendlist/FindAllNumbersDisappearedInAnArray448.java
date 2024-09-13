package leetcode.recommendlist;

import java.util.*;

public class FindAllNumbersDisappearedInAnArray448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        boolean[] exist = new boolean[len+1];

        for (int num : nums) {
            if (!exist[num]) {
                exist[num] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=len;i++) {
            if (!exist[i]) {
                list.add(i);
            }
        }

        return list;
    }
}
