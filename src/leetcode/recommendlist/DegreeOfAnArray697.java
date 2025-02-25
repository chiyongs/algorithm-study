package leetcode.recommendlist;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray697 {
    static class Subarray {
        int num;
        int firstIdx;
        int lastIdx;
        int cnt;

        public Subarray(int num, int idx) {
            this.num = num;
            this.firstIdx = idx;
            this.cnt = 1;
            this.lastIdx = idx;
        }
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Subarray> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            int num = nums[i];
            Subarray s = map.getOrDefault(num, null);
            if (s == null) {
                s = new Subarray(num, i);
                map.put(num, s);
            } else {
                s.cnt++;
                s.lastIdx = i;
            }
        }

        int maxCnt = 0;
        int minLen = nums.length;
        for (Map.Entry<Integer, Subarray> e : map.entrySet()) {
            Subarray s = e.getValue();
            int curLen = s.lastIdx - s.firstIdx + 1;
            if (s.cnt > maxCnt) {
                maxCnt = s.cnt;
                minLen = curLen;
            } else if (s.cnt == maxCnt) {
                minLen = Math.min(minLen, curLen);
            }
        }
        return minLen;
    }
}
