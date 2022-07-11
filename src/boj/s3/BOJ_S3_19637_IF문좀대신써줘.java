package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author chiyongs
 * @since 2022. 7. 11.
 * @see https://www.acmicpc.net/problem/19637
 * @performance 66592	620
 * @category #자료구조 #트리맵
 * @note열
 */
public class BOJ_S3_19637_IF문좀대신써줘 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeMap<Integer, String> map = new TreeMap<>(); // 전투력 상한 값, 칭호

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            map.put(num, map.getOrDefault(num, str)); // 만약 이미 해당 전투력 상한 값에 칭호가 존재한다면, 있는 칭호 넣기
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            int num = Integer.parseInt(br.readLine());
            // ceilingEntry사용해서 num값보다 큰 전투력 상한 값 중 가장 작은 값을 찾아서 칭호를 도출
            sb.append(map.ceilingEntry(num).getValue()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
