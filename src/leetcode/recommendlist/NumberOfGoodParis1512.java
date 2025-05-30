package leetcode.recommendlist;

public class NumberOfGoodParis1512 {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        int[] cnt = new int[101];

        for(int num: nums) {
            cnt[num]++;
        }

        for(int n: cnt) {
            result += (n * (n - 1))/2;
        }

        return result;
    }
}
