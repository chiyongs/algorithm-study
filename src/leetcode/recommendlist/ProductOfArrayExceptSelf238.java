package leetcode.recommendlist;

public class ProductOfArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int numsLen = nums.length;
        int[] answer = new int[numsLen];
        int prefixProduct = 1;
        int suffixProduct = 1;

        for (int i=0;i<numsLen;i++) {
            answer[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        for (int i=numsLen-1;i>=0;i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}
