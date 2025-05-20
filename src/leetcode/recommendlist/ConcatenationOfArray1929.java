package leetcode.recommendlist;

public class ConcatenationOfArray1929 {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] result = new int[len * 2];
        for (int i=0;i<len;i++) {
            result[i] = nums[i];
        }
        for (int i=len;i<2*len;i++) {
            result[i] = nums[i-len];
        }

        return result;
    }
}
