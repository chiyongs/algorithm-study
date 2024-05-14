package hackerrank;

import java.util.List;

public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        int max = 0;
        long sum = 0;
        for(int e : arr) {
            min = Math.min(min, e);
            max = Math.max(max, e);
            sum += e;
        }

        System.out.printf("%d %d",sum - max, sum - min);
    }
}
