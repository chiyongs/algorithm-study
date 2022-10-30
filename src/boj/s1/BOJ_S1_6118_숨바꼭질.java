package boj.s1;

import java.util.*;
import java.io.*;

/**
 * @author chiyongs
 * @since 2022. 10. 30.
 * @see https://www.acmicpc.net/problem/6118
 * @performance 31804	336
 * @category #BFS
 * @note
 */
public class BOJ_S1_6118_숨바꼭질 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num, line;
        int one, two;
        int[] maxIdx = new int[3];
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        visited = new boolean[num + 1];

        for (int x = 0; x <= num; x++) {
            list.add(new ArrayList<>());
        }

        for (int x = 0; x < line; x++) {
            st = new StringTokenizer(br.readLine());

            one = Integer.parseInt(st.nextToken());
            two = Integer.parseInt(st.nextToken());

            list.get(one).add(two);
            list.get(two).add(one);
        }


        queue.add(new Point(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.move > maxIdx[1]) {
                maxIdx[0] = now.edge;
                maxIdx[1] = now.move;
                maxIdx[2] = 1;
            } else if (now.move == maxIdx[1]) {
                maxIdx[2]++;
                maxIdx[0] = Math.min(maxIdx[0], now.edge);
            }

            for (int x : list.get(now.edge)) {
                if(visited[x])
                    continue;

                visited[x] = true;
                queue.add(new Point(x, now.move + 1));
            }
        }

        for(int x : maxIdx)
            sb.append(x).append(" ");

        System.out.println(sb);

    }

    public static class Point{
        int edge, move;

        Point(int edge, int move) {
            this.edge = edge;
            this.move = move;
        }
    }
}
