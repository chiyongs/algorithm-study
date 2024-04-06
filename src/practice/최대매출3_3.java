package practice;

import java.util.Scanner;

public class 최대매출3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i=0;i<K;i++) {
            sum += arr[i];
        }
        int answer = sum;
        int lt = 1, rt = K;
        while(rt < N) {
            sum = sum - arr[lt-1] + arr[rt];
            answer = Math.max(answer, sum);
            lt++;
            rt++;
        }

        System.out.println(answer);
    }
}
