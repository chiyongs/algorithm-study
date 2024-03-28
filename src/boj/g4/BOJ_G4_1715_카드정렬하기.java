package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_G4_1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n1-n2);
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
        }
        long answer = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            answer = answer + a + b;
            pq.offer(a+b);
        }
        System.out.println(answer);
    }
}
