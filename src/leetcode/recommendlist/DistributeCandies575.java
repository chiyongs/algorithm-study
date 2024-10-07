package leetcode.recommendlist;

import java.util.*;

public class DistributeCandies575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candySet = new HashSet<>();
        for (int candy : candyType) {
            candySet.add(candy);
        }
        return Math.min(candyType.length / 2, candySet.size());
    }
}
