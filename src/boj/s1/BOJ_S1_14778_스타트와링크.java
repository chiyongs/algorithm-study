package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S1_14778_스타트와링크 {

    static int N, arr[][], start[], link[];
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        answer = Integer.MAX_VALUE;
        visited = new boolean[N];
        start = new int[N/2];
        link = new int[N/2];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);
        System.out.println(answer);
    }

    static int calc(int[] list) {
        int sum = 0;
        for(int i=0;i<N/2;i++) {
            for(int j=0;j<N/2;j++) {
                sum += arr[list[i]][list[j]];
            }
        }
        return sum;
    }

    static void comb(int cnt, int st) {
        if (cnt == N/2) {
            int idx = 0;
            for(int i=0;i<N;i++) {
                if (!visited[i]) link[idx++] = i;
            }
            answer = Math.min(answer,Math.abs(calc(start) - calc(link)));
        } else {
            for(int i=st;i<N;i++) {
                visited[i] = true;
                start[cnt] = i;
                comb(cnt+1, i+1);
                visited[i] = false;
            }
        }
    }
}
