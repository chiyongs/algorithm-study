package leetcode.recommendlist;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        int min = -1, max = -1;
        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                min = mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                max = mid;
            }
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{min, max};
    }
}
