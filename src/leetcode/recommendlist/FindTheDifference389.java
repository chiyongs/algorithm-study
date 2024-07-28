package leetcode.recommendlist;

import java.util.*;

public class FindTheDifference389 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch : t.toCharArray()) {
            int cnt = map.getOrDefault(ch, 0);
            if (cnt == 0) {
                return ch;
            } else {
                map.put(ch, cnt-1);
            }
        }
        return 'a';
    }
}
