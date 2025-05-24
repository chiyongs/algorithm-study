package leetcode.recommendlist;

public class RemoveDuplicatesFromSortedArrayII80 {
    public int removeDuplicates(int[] nums) {
        int slow=2, fast = 2;
        while (fast < nums.length){
            if (nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        return slow;
    }
}
