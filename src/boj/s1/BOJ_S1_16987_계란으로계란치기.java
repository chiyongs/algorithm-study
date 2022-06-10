package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 10.
 * @see https://www.acmicpc.net/problem/16987
 * @performance 19352	408
 * @category #백트래킹
 * @note
 */
public class BOJ_S1_16987_계란으로계란치기 {

    static class Egg {
        int s, w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Egg{" +
                    "s=" + s +
                    ", w=" + w +
                    '}';
        }
    }

    static Egg[] eggs;
    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        go(0,0);

        System.out.println(answer);
    }

    static void go(int cur, int cnt) {
        if(cur == N) {
            int result = 0;
            for(int i=0;i<N;i++) {
                if(eggs[i].s <= 0) result++;
            }

            if(answer < result) answer= result;
            return;
        }

        for(int i=0;i<N;i++) {
            if(eggs[cur].s <= 0 || cnt >= N-1) {
                go(cur+1,cnt);
                break;
            }

            if(eggs[i].s >= 0 && i != cur) {
                eggs[cur].s -= eggs[i].w;
                eggs[i].s -= eggs[cur].w;
                if(eggs[cur].s <= 0 && eggs[i].s <= 0) {
                    go(cur+1, cnt+2);
                }
                else if(eggs[cur].s <= 0 && eggs[i].s > 0) go(cur+1,cnt+1);
                else if(eggs[cur].s > 0 && eggs[i].s <= 0) go(cur+1,cnt+1);
                else go(cur+1,cnt);
                eggs[cur].s += eggs[i].w;
                eggs[i].s += eggs[cur].w;

            }
        }
    }


}
