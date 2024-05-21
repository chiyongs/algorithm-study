package leetcode.recommendlist;

import java.util.*;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((i,j) -> j[1]-i[1]);
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
