package leetcode.recommendlist;

public class MinimumSizeSubarraySum209 {

    public static void main(String[] args) {
        MinimumSizeSubarraySum209 m = new MinimumSizeSubarraySum209();
//        m.minSubArrayLen(213, new int[]{12, 28,83,4,25,26,25,2,25,25,25,12});
        System.out.println(m.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;

        int sum = nums[0];
        if (sum >= target) {
            return 1;
        }
        int min = Integer.MAX_VALUE;;

        int left = 0, right = left;
        while (left <= right && right < length) {
            if (right == length - 1) {
                break;
            }
            if (nums[left] >= target) {
                return 1;
            }

            while (sum < target && right < length - 1) {
                sum += nums[++right];
                if (sum >= target) {
                    min = Math.min(min, right - left + 1);
                    break;
                }
            }

            while(sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
