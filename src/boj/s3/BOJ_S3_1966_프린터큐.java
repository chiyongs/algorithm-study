package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chiyongs
 * @since 2022. 6. 27.
 * @see https://www.acmicpc.net/problem/1966
 * @performance 12612	108
 * @category #구현
 * @note
 */
public class BOJ_S3_1966_프린터큐 {

    static class Document implements Comparable<Document>{
        int idx, priority;

        public Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        @Override
        public int compareTo(Document o) {
            return this.idx - o.idx;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> documents = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++) {
                int x = Integer.parseInt(st.nextToken());
                documents.offer(new Document(i,x));
                pq.offer(x);
            }

            int cnt = 1;
            while(!documents.isEmpty()) {
                Document cur = documents.poll();

                if(cur.priority < pq.peek()) {
                    documents.offer(cur);
                } else {
                    if(cur.idx == M) break;
                    pq.poll();
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb.toString());
    }
}
