package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_6550_부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while ((str = br.readLine())!= null) {
            String s = str.split(" ")[0];
            String t = str.split(" ")[1];

            int idx = 0;
            for (int i = 0; i < t.length(); i++) {
                if (idx >= s.length()) break;
                if (t.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
            }
            if (idx == s.length()) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
