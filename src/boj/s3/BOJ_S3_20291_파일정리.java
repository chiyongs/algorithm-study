package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ_S3_20291_파일정리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();
        for(int n=0;n<N;n++) {
            String file = br.readLine();
            String extension = file.split("\\.")[1];
            map.put(extension, map.getOrDefault(extension, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
