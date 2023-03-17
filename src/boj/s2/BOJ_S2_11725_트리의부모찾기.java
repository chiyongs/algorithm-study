package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chiyongs
 * @since 2023. 03. 17.
 * @see https://www.acmicpc.net/problem/11725
 * @performance 74580	628
 * @category #트리 #BFS
 * @note
 */
public class BOJ_S2_11725_트리의부모찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] parents = new int[N+1];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> aList = map.getOrDefault(a, new ArrayList<>());
            List<Integer> bList = map.getOrDefault(b, new ArrayList<>());

            aList.add(b);
            bList.add(a);

            map.put(a, aList);
            map.put(b, bList);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        parents[1] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> nums = map.get(cur);

            for(Integer num : nums) {
                if (parents[num] == 0) {
                    q.offer(num);
                    parents[num] = cur;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=2;i<=N;i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }
}
