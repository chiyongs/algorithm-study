package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 13.
 * @see https://www.acmicpc.net/problem/15652
 * @performance 14656	100
 * @category #백트래킹 #순열
 * @note
 */
public class BOJ_S3_15652_N과M4 {

    static int N,M;
    static int[] nums;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        isSelected = new boolean[N+1];

        comb(0,1);

        System.out.println(sb.toString());
    }

    static void comb(int cnt, int start) {
        if(cnt == M) {
            for(int i=0;i<M;i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }

        for(int i=start;i<=N;i++) {
            nums[cnt] = i;
            comb(cnt+1, i);
        }
    }
}

