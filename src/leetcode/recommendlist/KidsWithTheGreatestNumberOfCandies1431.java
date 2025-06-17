package leetcode.recommendlist;

import java.util.*;

public class KidsWithTheGreatestNumberOfCandies1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int candy : candies) {
            boolean flag = false;
            if (candy + extraCandies >= max) {
                flag = true;
            }
            result.add(flag);
        }
        return result;
    }
}
