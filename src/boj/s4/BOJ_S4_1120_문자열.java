package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 8. 1.
 * @see https://www.acmicpc.net/problem/1120
 * @performance 11492	80
 * @category #문자열 #완전탐색
 * @note
 */
public class BOJ_S4_1120_문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        String A = st.nextToken();
        String B = st.nextToken();

        int min = 50;
        for(int i=0;i<=B.length()-A.length();i++) {
            int cnt = 0;
            for(int j=0;j<A.length();j++) {
                if(A.charAt(j) != B.charAt(i+j)) {
                    cnt++;
                }
            }
            if(cnt < min) min = cnt;
            cnt = 0;
        }

        System.out.println(min);
    }
}
