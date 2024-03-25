package practice;

import java.util.Scanner;

public class 뮤직비디오6_9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        int lt = 0, rt = 0;
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
            lt = Math.max(arr[i], lt);
            rt += arr[i];
        }

        int answer = Integer.MAX_VALUE;
        while(lt <= rt) {
            int cnt = 1;
            int mid = (lt + rt) / 2;
            int sum = 0;
            for(int i=0;i<N;i++) {
                if (sum + arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    cnt++;
                    sum = arr[i];
                }
            }
            if (cnt <= M) {
                rt = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
