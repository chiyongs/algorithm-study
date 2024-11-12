package leetcode.recommendlist;

import java.util.Arrays;

public class ThreeSumClosest16 {

    public int threeSumClosestV1(int[] nums, int target) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int twoSum = nums[i] + nums[j];
                for (int k = j + 1; k < len; k++) {
                    int threeSum = twoSum + k;
                    if (threeSum == target) {
                        return target;
                    } else {
                        int minDist = Math.abs(min - target);
                        int dist = Math.abs(threeSum - target);

                        if (minDist > dist) {
                            min = threeSum;
                        }
                    }
                }
            }
        }

        return min;
    }

    public int threeSumClosestV2(int[] nums, int target) {
        int len = nums.length;

        int min = Integer.MAX_VALUE;

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                int minDist = Math.abs(min - target);
                int dist = Math.abs(sum - target);

                if (sum == target) {
                    return target;
                }

                if (dist < minDist) {
                    min = sum;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return min;
    }
}
