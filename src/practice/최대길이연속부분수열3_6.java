package practice;

import java.util.Scanner;

public class 최대길이연속부분수열3_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        int lt=0,rt=0;
        int cnt = 0;
        int sum = 0;
        int answer = 0;

        while(rt < n-1) {
            boolean isZero = arr[rt+1] == 0;
            if (isZero) {
                if (cnt < k) {
                    cnt++;
                    sum++;
                    ++rt;
                    if (rt == n-1) break;
                } else {
                    lt++;
                    if (arr[lt] == 0) {
                        cnt--;
                    }
                    sum--;
                }
            } else {
                sum++;
                rt++;
                if (rt == n-1) break;
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
