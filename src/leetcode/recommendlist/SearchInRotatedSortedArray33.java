package leetcode.recommendlist;

public class SearchInRotatedSortedArray33 {

    public static void main(String[] args) {
        SearchInRotatedSortedArray33 s = new SearchInRotatedSortedArray33();
        int[] nums = {4,5,6,7,0,1,2};
        s.search(nums, 0);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) return 0;
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;

            if (nums[mid] < target) {
                right = mid;
            } else if (nums[mid] > target) {
                left = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
