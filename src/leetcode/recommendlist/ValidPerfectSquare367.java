package leetcode.recommendlist;

public class ValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long left = 1, right = num;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long product = mid * mid;
            if (product == num) {
                return true;
            } else if (product < num) {
                left = mid + 1;
            } else if (product > num) {
                right = mid - 1;
            }
        }
        return false;
    }
}
