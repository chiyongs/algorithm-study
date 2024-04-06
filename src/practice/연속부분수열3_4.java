package practice;

import java.util.Scanner;

public class 연속부분수열3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        int sum = arr[0];
        int lt = 0, rt = 0;
        while(rt < N) {
            if (sum < M) {
                if (rt == N-1) break;
                sum += arr[++rt];
            } else if (sum > M) {
                sum -= arr[lt++];
            } else {
                cnt++;
                if (rt == N-1) break;
                sum -= arr[lt++];
                sum += arr[++rt];
            }
        }
        System.out.println(cnt);
    }
}
