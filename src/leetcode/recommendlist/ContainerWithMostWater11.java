package leetcode.recommendlist;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxAmount = 0;

        while(left < right) {
            maxAmount = Math.max(maxAmount, getAmount(left, right, height));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxAmount;
    }

    int getAmount(int left, int right, int[] height) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}
