package leetcode.recommendlist;

import java.util.*;

public class FizzBuzz412 {
    static final String FIZZ_BUZZ = "FizzBuzz";
    static final String FIZZ = "Fizz";
    static final String BUZZ = "Buzz";

    public List<String> fizzBuzz(int n) {
        String[] result = new String[n];

        for (int i = 1; i <= n; i++) {
            boolean dividedByThree = i % 3 == 0;
            boolean dividedByFive = i % 5 == 0;
            if (dividedByThree && dividedByFive) {
                result[i - 1] = FIZZ_BUZZ;
            } else if (dividedByThree) {
                result[i - 1] = FIZZ;
            } else if (dividedByFive) {
                result[i - 1] = BUZZ;
            } else {
                result[i - 1] = (i + "");
            }
        }
        return Arrays.asList(result);
    }
}
