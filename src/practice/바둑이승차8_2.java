package practice;

import java.util.Scanner;

public class 바둑이승차8_2 {

    static int N, C;
    static int[] arr;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();

        arr = new int[N];
        answer = 0;
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int cnt, int sum) {
        if (sum > C) return;
        if (cnt == N) {
            answer = Math.max(answer, sum);
        } else {
            dfs(cnt+1, sum+arr[cnt]);
            dfs(cnt+1, sum);
        }
    }
}
