package leetcode.recommendlist;

public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (mid == 0) {
                return nums[0] >= nums[1] ? 0 : 1;
            }
            if (mid == right) {
                return nums[right-1] >= nums[right-2] ? right - 1 : right - 2;
            }

            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if (nums[mid-1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
