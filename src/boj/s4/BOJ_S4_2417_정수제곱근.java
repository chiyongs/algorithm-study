package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S4_2417_정수제곱근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long lt = 0;
        long rt = n;
        long mid = 0;
        long prev = 0;
        while(lt <= rt) {
            mid = (lt + rt) / 2;
            if (Math.pow(mid, 2) >= n) {
                rt = mid - 1;
                prev = mid;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(prev);
    }
}
