package leetcode.recommendlist;

public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while (res != 0) {
            int rsb = res & -res;
            res -= rsb;
            count++;
        }
        return count;
    }
}
