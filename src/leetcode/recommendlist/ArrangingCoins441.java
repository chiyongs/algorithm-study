package leetcode.recommendlist;

public class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        int i = 1;
        while (n > 0) {
            i++;
            n = n-i;
        }
        return i-1;
    }
}
