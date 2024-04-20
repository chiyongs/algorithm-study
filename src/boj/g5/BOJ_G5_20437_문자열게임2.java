package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_G5_20437_문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++) {
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            Map<Character, Integer> map = new HashMap<>();
            for(int i=0;i<str.length();i++) {
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }

            int min = Integer.MAX_VALUE;
            int max = 0;
            for(int i=0;i<str.length();i++) {
                if (map.get(str.charAt(i)) < K) continue;
                int cnt = 0;
                for(int j=i;j<str.length();j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        cnt++;
                    } else continue;
                    if (cnt == K) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }
            if (max != 0) sb.append(min).append(" ").append(max).append("\n");
            else sb.append(-1).append("\n");
        }

        System.out.print(sb.toString());
    }

}
