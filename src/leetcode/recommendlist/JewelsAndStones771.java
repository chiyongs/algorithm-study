package leetcode.recommendlist;

import java.util.*;

public class JewelsAndStones771 {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (char stone : stones.toCharArray()) {
            map.put(stone, map.getOrDefault(stone, 0)+1);
        }

        int numJewels = 0;
        for (char jewel : jewels.toCharArray()) {
            int cnt = map.getOrDefault(jewel, 0);
            if (cnt != 0) {
                numJewels += cnt;
            }
        }
        return numJewels;
    }
}
