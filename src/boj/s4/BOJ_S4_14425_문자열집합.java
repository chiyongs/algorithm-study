package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S4_14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            list.add(br.readLine());
        }

        int answer = 0;
        for(int i=0;i<M;i++) {
            if (list.contains(br.readLine())) answer++;
        }

        System.out.println(answer);
    }
}
