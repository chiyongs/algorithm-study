package leetcode.recommendlist;

import java.util.*;

public class FirstUniqueCharacterInAString387 {
    public int firstUniqChar(String s) {
        Map<Character, int[]> indexMap = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            int[] idxAndCnt = indexMap.getOrDefault(ch, new int[2]);
            idxAndCnt[1]++;
            if (idxAndCnt[0] == 0) {
                idxAndCnt[0] = i;
            }
            indexMap.put(ch, idxAndCnt);
        }

        int min = Integer.MAX_VALUE;
        for(int[] idxAndCnt : indexMap.values()) {
            if (idxAndCnt[1] == 1) {
                min = Math.min(min, idxAndCnt[0]);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
