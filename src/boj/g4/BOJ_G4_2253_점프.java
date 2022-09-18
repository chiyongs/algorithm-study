package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2253_점프 {

    static boolean[] stones;
    static int N,M;
    static int[] dx = {-1,0,1};
    static int[] distance;

    static class Step {
        int loc, amount;

        public Step(int loc, int amount) {
            this.loc = loc;
            this.amount = amount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stones = new boolean[N+1];
        distance = new int[N+1];
        Arrays.fill(stones, true);

        for(int i=0;i<M;i++) {
            int small = Integer.parseInt(br.readLine());
            stones[small] = false;
        }

        if(!stones[2]) {
            System.out.println(-1);
            System.exit(0);
        }

        jump();

        System.out.println(distance[N] == 0 ? -1 : distance[N]);

    }

    static void jump() {
        Queue<Step> Q = new LinkedList<>();
        Q.offer(new Step(2,1));
        distance[1] = 1;
        distance[2] = 1;

        while(!Q.isEmpty()) {
            Step cur = Q.poll();

            for(int d=0;d<3;d++) {
                int nr = cur.loc + cur.amount + dx[d];

                if(cur.amount + dx[d] < 1 || nr < 1 || nr > N || distance[nr] > 0 || !stones[nr]) continue;

                Q.offer(new Step(nr, cur.amount + dx[d]));
                distance[nr] = distance[cur.loc] + 1;
            }
        }
    }
}
