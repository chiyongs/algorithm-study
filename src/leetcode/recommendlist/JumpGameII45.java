package leetcode.recommendlist;

public class JumpGameII45 {
    public int jump(int[] nums) {
        int reachable = 0;
        int curEnd = 0;
        int cnt = 0;

        for(int i=0;i<nums.length-1;i++) {
            reachable = Math.max(reachable, i+nums[i]);
            if (curEnd == i) {
                cnt++;
                curEnd = reachable;
            }
        }
        return cnt;
    }
}
