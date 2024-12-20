package leetcode.recommendlist;

import java.util.Arrays;

public class SingleNumberIII260 {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] result = new int[2];
        for(int i = 0; i < len; ){
            if(i != len - 1 && nums[i] == nums[i+1]) i += 2;
            else{
                if(result[0] == 0) result[0] = nums[i];
                else result[1] = nums[i];
                i++;
            }
        }
        return result;
    }
}
