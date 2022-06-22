package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 6. 22.
 * @see https://www.acmicpc.net/problem/10974
 * @performance 20564	180
 * @category #백트래킹 #순열
 * @note
 */
public class BOJ_S3_10974_모든순열 {

    static int[] input,num;
    static int N;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        num = new int[N];
        isSelected = new boolean[N];

        for(int i=0;i<N;i++) {
            input[i] = i+1;
        }

        perm(0);

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }


    static void perm(int cnt) {
        if(cnt == N) {
            for(int i=0;i<N;i++) {
                sb.append(num[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;
            num[cnt] = input[i];
            perm(cnt+1);
            isSelected[i] = false;
        }
    }
}
