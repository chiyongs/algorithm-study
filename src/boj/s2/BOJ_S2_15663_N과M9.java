package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chiyongs
 * @since 2022. 6. 25.
 * @see https://www.acmicpc.net/problem/15663
 * @performance 35556	616
 * @category #백트래킹 #순열
 * @note
 */
public class BOJ_S2_15663_N과M9 {

    static int N,M, input[], num[];
    static boolean[] isSelected;
    static Set<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = new LinkedHashSet<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        isSelected = new boolean[N];
        num = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        perm(0);
        for(String str : answer) {
            System.out.println(str);
        }
    }

    static void perm(int cnt) {
        if(cnt == M) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<M;i++) {
                sb.append(num[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            answer.add(sb.toString());
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
