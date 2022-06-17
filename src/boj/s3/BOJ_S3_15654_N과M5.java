package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 17.
 * @see https://www.acmicpc.net/problem/15654
 * @performance 31840	256
 * @category #백트래킹 #순열
 * @note
 */
public class BOJ_S3_15654_N과M5 {

    static int N,M;
    static boolean[] isSelected;
    static int[] input, nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        isSelected = new boolean[N];
        nums = new int[M];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        perm(0);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    static void perm(int cnt) {
        if(cnt == M) {
            for(int i=0;i<M;i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;
            nums[cnt] = input[i];
            perm(cnt+1);
            isSelected[i] = false;
        }
    }
}
