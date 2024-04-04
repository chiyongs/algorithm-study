package practice;

import java.util.*;

public class 동전교환8_4 {

    static Integer[] coins;
    static int N,M, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coins = new Integer[N];
        for(int i=0;i<N;i++) {
            coins[i] = sc.nextInt();
        }
        M = sc.nextInt();
        answer = Integer.MAX_VALUE;
        Arrays.sort(coins, Collections.reverseOrder());
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int cnt, int sum) {
        if (sum > M || cnt >= answer) {
            return;
        }
        if (sum == M) {
            answer = Math.min(cnt, answer);
        }
        else {
            for(int i=0;i<N;i++) {
                dfs(cnt+1, sum + coins[i]);
            }
        }
    }
}
