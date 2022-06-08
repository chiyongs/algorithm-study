package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 9.
 * @see https://www.acmicpc.net/problem/10819
 * @performance 12500	116
 * @category #순열
 * @note
 */
public class BOJ_S2_10819_차이를최대로 {

    static int N, arr[], input[],answer;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        input = new int[N];
        isSelected = new boolean[N];
        answer = 0;
        for(int i=0;i<N;i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        System.out.println(answer);
    }

    static void perm(int cnt) {
        if(cnt == N) {
            int sum = 0;
            for(int i=0;i<N-1;i++) {
                sum += Math.abs(arr[i] - arr[i+1]);
            }

            if(answer < sum) answer = sum;

            return;
        }

        for(int i=0;i<N;i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;
            arr[cnt] = input[i];
            perm(cnt+1);
            isSelected[i] = false;
        }
    }
}
