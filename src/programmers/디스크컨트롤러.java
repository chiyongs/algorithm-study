package programmers;

import java.util.*;

public class 디스크컨트롤러 {

    public int solution(int[][] jobs) {
        PriorityQueue<int[]> seq = new PriorityQueue<>((j1,j2) -> j1[0] - j2[0]);
        PriorityQueue<int[]> in = new PriorityQueue<>((j1,j2) -> j1[1] - j2[1]);

        int len = jobs.length;
        for(int i=0;i<len;i++) {
            seq.offer(jobs[i]);
        }

        int answer = 0;
        int time = 0;
        while(!seq.isEmpty() || !in.isEmpty()) {
            while(!seq.isEmpty() && seq.peek()[0] <= time) {
                in.offer(seq.poll());
            }

            if(in.isEmpty()) {
                time = seq.peek()[0];
            } else {
                int[] cur = in.poll();
                answer = time - cur[0] + cur[1] + answer;
                time += cur[1];
            }
        }

        return answer / len;
    }
}
