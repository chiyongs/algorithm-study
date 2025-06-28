package leetcode.recommendlist;

public class CountTheDigitsThatDivideANumber2520 {
    public int countDigits(int num) {
        int cnt = 0;
        int origin = num;
        while (num > 0) {
            int res = num % 10;
            if (origin % res == 0) {
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }
}
