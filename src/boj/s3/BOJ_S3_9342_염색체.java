package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_9342_염색체 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String regex = "[A-F]?A+F+C+[A-F]?$";
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            boolean result = str.matches(regex);
            if (result) {
                sb.append("Infected!\n");
            } else {
                sb.append("Good\n");
            }
        }
        System.out.print(sb.toString());
    }
}
