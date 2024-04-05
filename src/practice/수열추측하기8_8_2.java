package practice;

import java.util.Scanner;

public class 수열추측하기8_8_2 {

    static int N,F;
    static int[][] dy = new int[35][35];
    static int[] nums, arr;
    static boolean flag,visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        F = sc.nextInt();
        nums = new int[N];
        visited = new boolean[N+1];
        flag = false;
        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = comb(N-1, i);
        }

        perm(0);
    }

    static void perm(int cnt) {
        if (flag) return;
        if (cnt == N) {
            int sum = 0;
            for(int i=0;i<N;i++) {
                sum = sum + (nums[i] * arr[i]);
            }
            if (sum == F) {
                flag = true;
                for(int x : nums) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        } else {
            for(int i=1;i<=N;i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    nums[cnt] = i;
                    perm(cnt+1);
                    visited[i] = false;
                }
            }
        }
    }

    static int comb(int n, int r) {
        if (n == r || r == 0) return dy[n][r] = 1;
        if (r == 1) return dy[n][r] = n;
        else {
            return dy[n][r] = comb(n-1,r) + comb(n-1,r-1);
        }
    }
}
