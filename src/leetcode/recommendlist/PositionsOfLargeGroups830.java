package leetcode.recommendlist;

import java.util.*;

public class PositionsOfLargeGroups830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] chArr = s.toCharArray();
        char prev = chArr[0];
        int cnt = 1;
        int idx = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i=1;i<chArr.length;i++) {
            char cur = chArr[i];
            if (cur == prev) {
                cnt++;
            } else {
                if (cnt >= 3) {
                    result.add(List.of(idx, i-1));
                }
                idx = i;
                cnt = 1;
                prev = cur;
            }
        }
        if (cnt >= 3) {
            result.add(List.of(idx, chArr.length-1));
        }
        return result;
    }
}
