package leetcode.recommendlist;

import java.util.*;

public class FourSumII454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        List<Integer> A = new ArrayList<>();
        Map<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (!aMap.containsKey(sum)) {
                    A.add(sum);
                }
                aMap.put(sum, aMap.getOrDefault(sum, 0) + 1);
            }
        }

        List<Integer> B = new ArrayList<>();
        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                if (!bMap.containsKey(sum)) {
                    B.add(sum);
                }
                bMap.put(sum, bMap.getOrDefault(sum, 0) + 1);
            }
        }

        int cnt = 0;
        for (int key : aMap.keySet()) {
            int target = -key;
            if (bMap.containsKey(target)) {
                cnt += aMap.get(-target) * bMap.get(target);
            }
        }

        return cnt;
    }

    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put((i + j), map.getOrDefault((i + j), 0) + 1);
            }
        }

        int cnt = 0;
        for (int l : nums3) {
            for (int k : nums4) {
                cnt += map.getOrDefault(-(l + k), 0);
            }
        }

        return cnt;
    }
}
