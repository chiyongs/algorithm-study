package leetcode.recommendlist;

public class MinimumBitFlipsToConvertNumber2220 {
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
