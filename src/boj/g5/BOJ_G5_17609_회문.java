package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_17609_회문 {

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int right = str.length() - 1;
            int left = 0;
            result = Integer.MAX_VALUE;
            checkPalin(str, left, right, 0);
            if (result >= 2) result = 2;
            sb.append(result).append("\n");
            System.out.print(sb.toString());
        }
    }

    static void checkPalin(String str, int lt, int rt, int cnt) {
        if (cnt >= 2) return;
        if (lt >= rt) {
            result = Math.min(result, cnt);
        } else {
            if (str.charAt(lt) == str.charAt(rt)) {
                checkPalin(str, lt + 1, rt - 1, cnt);
            } else {
                checkPalin(str, lt + 1, rt, cnt + 1);
                checkPalin(str, lt, rt - 1, cnt + 1);
            }
        }
    }
}


