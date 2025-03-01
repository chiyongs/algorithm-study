package leetcode.recommendlist;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int i=left;i<=right;i++) {
            int num = i;
            boolean flag = true;
            while (num != 0) {
                int div = num % 10;
                if (div == 0) {
                    flag = false;
                    break;
                }
                if (!(i % div == 0)) {
                    flag = false;
                    break;
                }
                num /= 10;
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }
}
