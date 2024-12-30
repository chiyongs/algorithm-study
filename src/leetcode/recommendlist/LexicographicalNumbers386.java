package leetcode.recommendlist;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers386 {
    public List<Integer> lexicalOrder(int n) {
        int curr = 1;
        List<Integer> result = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            result.add(curr);

            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr >= n) {
                    curr /= 10;
                }
                curr += 1;
            }
        }
        return result;
    }
}
