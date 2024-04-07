package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_17140_이차원배열과연산 {

    static class Node implements Comparable<Node> {
        int number;
        int count;

        Node(int n, int c) {
            this.number = n;
            this.count = c;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count == o.count) {
                return this.number - o.number;
            }
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()) - 1;
        int C = Integer.parseInt(st.nextToken()) - 1;
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[3][3];
        for(int i=0;i<3;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = -1;
        for(int i=0;i<=100;i++) {
            if (R < arr.length && C < arr[0].length && arr[R][C] == K) {
                min = i;
                break;
            }
            if (arr.length >= arr[0].length) {
                arr = R(arr);
            } else {
                arr = C(arr);
            }
        }
        System.out.println(min);

    }

    static int[][] R(int[][] arr) {
        List<int[]> list = new ArrayList<>();
        int maxSize = 0;
        for(int i=0;i<arr.length;i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<arr[0].length;j++) {
                if (arr[i][j] == 0) continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(Map.Entry<Integer, Integer> e : map.entrySet()) {
                pq.offer(new Node(e.getKey(), e.getValue()));
            }

            int[] newArr = new int[pq.size()*2];
            for(int j=0;j<newArr.length;j+=2) {
                Node n = pq.poll();
                newArr[j] = n.number;
                newArr[j+1] = n.count;
            }

            list.add(newArr);
            maxSize = Math.max(maxSize, newArr.length);
        }
        int[][] r = new int[arr.length][maxSize];
        for(int i=0;i<r.length;i++) {
            int[] t = list.get(i);
            for(int j=0;j<t.length;j++) {
                r[i][j] = t[j];
            }
        }
        return r;
    }

    static int[][] C(int[][] arr) {
        List<int[]> list = new ArrayList<>();
        int maxSize = 0;
        for(int i=0;i<arr[0].length;i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<arr.length;j++) {
                if (arr[j][i] == 0) continue;
                map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(Map.Entry<Integer, Integer> e : map.entrySet()) {
                pq.offer(new Node(e.getKey(), e.getValue()));
            }

            int[] newArr = new int[pq.size()*2];
            for(int j=0;j<newArr.length;j+=2) {
                Node n = pq.poll();
                newArr[j] = n.number;
                newArr[j+1] = n.count;
            }

            list.add(newArr);
            maxSize = Math.max(maxSize, newArr.length);
        }
        int[][] r = new int[maxSize][arr[0].length];
        for(int i=0;i<r[0].length;i++) {
            int[] t = list.get(i);
            for(int j=0;j<t.length;j++) {
                r[j][i] = t[j];
            }
        }
        return r;
    }

}
