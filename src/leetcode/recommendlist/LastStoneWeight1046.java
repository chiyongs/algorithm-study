package leetcode.recommendlist;

import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (!pq.isEmpty() && pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first - second);
        }
        return pq.poll();
    }
}
