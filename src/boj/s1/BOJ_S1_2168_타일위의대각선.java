package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 9.
 * @see https://www.acmicpc.net/problem/2168
 * @performance 11552	76
 * @category #수학
 * @note열
 */
public class BOJ_S1_2168_타일위의대각선 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int result = gcd(x, y);
        System.out.println(x+y-result);
    }

    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
