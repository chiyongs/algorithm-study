package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 11.
 * @see https://www.acmicpc.net/problem/15658
 * @performance 13312	92
 * @category #백트래킹
 * @note
 */
public class BOJ_S2_15658_연산자끼워넣기2 {

    static int N,nums[],ops[],min,max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        nums = new int[N];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        ops = new int[4];
        for(int i=0;i<4;i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        go(1,nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void go(int cnt, int result) {
        if(cnt == N) {
            if(result < min) min = result;
            if(result > max) max = result;

            return;
        }

        for(int i=0;i<4;i++) {
            if(ops[i] == 0) continue;

            ops[i]--;
            if(i==0) {
                go(cnt+1, result+nums[cnt]);
            } else if(i==1) {
                go(cnt+1, result-nums[cnt]);
            } else if(i==2) {
                go(cnt+1, result*nums[cnt]);
            } else {
                go(cnt+1, result / nums[cnt]);
            }
            ops[i]++;
        }
    }


}
