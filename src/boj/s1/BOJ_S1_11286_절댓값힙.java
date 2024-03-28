package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chiyongs
 * @since 2024. 3. 28.
 * @see https://www.acmicpc.net/problem/11286
 * @performance 23208	296
 * @category #우선순위 큐
 * @note
 */
public class BOJ_S1_11286_절댓값힙 {

    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Comparator<Integer> comp = (o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) {
                return o1 - o2;
            }
            return abs1 - abs2;
        };
        pq = new PriorityQueue<>(comp);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.offer(x);
            } else {
                Integer result = pq.poll();
                sb.append(result == null ? 0 : result).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
