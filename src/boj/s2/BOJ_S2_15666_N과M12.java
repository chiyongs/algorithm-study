package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 16.
 * @see https://www.acmicpc.net/problem/15666
 * @performance 13636	112
 * @category #백트래킹 #순열
 * @note
 */
public class BOJ_S2_15666_N과M12 {

    static int N,M;
    static int[] arr,isSelected;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isSelected = new int[M];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        comb(0,0);

        StringBuilder sb = new StringBuilder();
        for(String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void comb(int cnt, int start) {
        if(cnt == M) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<M;i++) {
                sb.append(isSelected[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);

            set.add(sb.toString());
            return;
        }

        for(int i=start;i<N;i++) {
            isSelected[cnt] = arr[i];
            comb(cnt+1, i);
        }
    }
}
