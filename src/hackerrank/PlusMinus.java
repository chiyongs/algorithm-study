package hackerrank;

import java.util.List;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for(int e : arr) {
            if (e > 0) positive++;
            else if (e < 0) negative++;
            else zero++;
        }

        int total = arr.size();

        double posRatio = (double) positive / (double) total;
        double negRatio = (double) negative / (double) total;
        double zerRatio = (double) zero / (double) total;

        System.out.printf("%.6f\n", posRatio);
        System.out.printf("%.6f\n", negRatio);
        System.out.printf("%.6f\n", zerRatio);
    }

}
