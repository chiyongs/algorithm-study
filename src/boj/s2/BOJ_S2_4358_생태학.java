package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ_S2_4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int count = 0;
        Map<String, Integer> trees = new TreeMap<>();

        while(true) {
            count++;
            trees.put(input, trees.getOrDefault(input, 0 ) + 1);

            input = br.readLine();
            if(input == null || input.length() == 0) break;
        }

        for(String tree : trees.keySet()) {
            int treeCnt = trees.get(tree);
            sb.append(tree).append(" ").append(String.format("%.4f", ((double) treeCnt / (double) count) * 100)).append("\n");
        }

        System.out.println(sb);

    }
}
