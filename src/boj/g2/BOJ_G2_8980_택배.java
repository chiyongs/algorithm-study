package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * @author chiyongs
 * @since 2022. 9. 30.
 * @see https://www.acmicpc.net/problem/8980
 * @performance 18640	292
 * @category #그리디
 * @note
 */

public class BOJ_G2_8980_택배 {

    static class Box implements Comparable<Box> {
        int from;
        int to;
        int weight;

        public Box(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Box o) {
            if (this.to == o.to) {
                return this.from - o.from;
            }
            return this.to - o.to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        Box[] boxes = new Box[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            boxes[i] = new Box(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(boxes);

        int[] towns = new int[N + 1];
        Arrays.fill(towns, C);
        int result = 0;

        for (int i = 0; i < M; i++) {
            int min = 10001;
            for (int j = boxes[i].from; j < boxes[i].to; j++) {
                min = Math.min(min, towns[j]);
            }

            min = Math.min(boxes[i].weight,min);

            for (int j = boxes[i].from; j < boxes[i].to; j++) {
                towns[j] -= min;
            }
            result += min;
        }

        System.out.println(result);
    }
}
