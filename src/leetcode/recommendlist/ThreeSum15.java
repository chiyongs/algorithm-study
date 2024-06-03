package leetcode.recommendlist;

import java.util.*;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {

            // nums[i-1] == nums[i]인 상황이라면 이미 해당 값으로 만들 수 있는 triplet을 다 만들었기 때문에 더 해볼 필요가 없음
            if (i!=0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
