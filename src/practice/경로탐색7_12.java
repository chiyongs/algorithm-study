package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 경로탐색7_12 {

    static int N,M,answer;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        for (int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from][to] = 1;
        }

        boolean[] visited = new boolean[N+1];
        dfs(1, 0, visited);
        System.out.println(answer);
    }

    static void dfs(int cur, int cnt, boolean[] visited) {
        if (cur == N) {
            answer++;
            return;
        }
        for(int i=1;i<=N;i++) {
            if (arr[cur][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, cnt+1,copy(visited));
            }
        }
    }

    static boolean[] copy(boolean[] arr) {
        boolean[] temp = new boolean[arr.length];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        return temp;
    }
}
