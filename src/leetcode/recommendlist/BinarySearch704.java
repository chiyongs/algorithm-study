package leetcode.recommendlist;

public class BinarySearch704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            int cur = nums[mid];
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
