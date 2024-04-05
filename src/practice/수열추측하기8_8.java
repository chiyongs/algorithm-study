package practice;

import java.util.Scanner;

public class 수열추측하기8_8 {

    static boolean[] visited;
    static int[] arr;
    static int N,F;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        F = sc.nextInt();

        visited = new boolean[N+1];
        arr = new int[N];
        flag = false;

        perm(0);
    }

    static int func(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] + nums[1];
        }
        int[] temp = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++) {
            temp[i] = nums[i] + nums[i+1];
        }
        return func(temp);
    }

    static void perm(int cnt) {
        if (flag) return;
        if (cnt == N) {
            int result = func(arr);
            if (result == F) {
                flag = true;
                for(int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        } else {
            for(int i=1;i<=N;i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[cnt] = i;
                    perm(cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}
