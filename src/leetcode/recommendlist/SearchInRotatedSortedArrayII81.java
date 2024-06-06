package leetcode.recommendlist;

public class SearchInRotatedSortedArrayII81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while(left < right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return nums[left] == target;
    }
}
