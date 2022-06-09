package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 6. 9.
 * @see https://www.acmicpc.net/problem/2529
 * @performance 40572	224
 * @category #순열
 * @note
 */
public class BOJ_S2_2529_부등호 {

    static int k;
    static long max,min;
    static boolean[] isSelected;
    static char[] ch;
    static String min_answer,max_answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        max = 0;
        min = Long.MAX_VALUE;
        isSelected = new boolean[10];
        ch = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            ch[i] = st.nextToken().charAt(0);
        }

        for(int i=0;i<10;i++) {
            int[] arr = new int[k+1];
            arr[0] = i;
            isSelected[i] = true;
            dfs(1,arr);
            isSelected[i] = false;
        }


        System.out.println(max_answer);
        System.out.println(min_answer);
    }

    static void dfs(int cnt, int[] arr) {
        if(cnt == k+1) {
            String tmp = "";
            for(int x : arr) {
                tmp += x;
            }

            long result = Long.parseLong(tmp);
            if(result > max) {
                max = result;
                max_answer = tmp;
            }
            if(result < min) {
                min = result;
                min_answer = tmp;
            }
            return;
        }

        for(int i=0;i<10;i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;
            if(ch[cnt-1] == '<' && arr[cnt-1] < i) {
                arr[cnt] = i;
                dfs(cnt+1, arr);
            }
            if(ch[cnt-1] == '>' && arr[cnt-1] > i) {
                arr[cnt] = i;
                dfs(cnt+1, arr);
            }
            isSelected[i] = false;
        }
    }

}
