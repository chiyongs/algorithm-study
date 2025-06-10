package leetcode.recommendlist;

import java.util.*;

public class TheTwoSneakyNumbersOfDigitville3289 {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> sneakyNumbers = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                sneakyNumbers.add(num);
            } else {
                set.add(num);
            }
        }

        int[] result = new int[sneakyNumbers.size()];
        int idx = 0;
        for (int sn : sneakyNumbers) {
            result[idx++] = sn;
        }
        return result;
    }
}
