package practice;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기6_10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int lt = Integer.MAX_VALUE;
        int rt = arr[N-1] - arr[0];
        for(int i=N-1;i>0;i--) {
            lt = Math.min(lt,arr[i] - arr[i-1]);
        }

        int mid = 0;
        int answer = 0;
        while(lt<=rt) {
            int cnt = 1;
            int temp = N-1;
            mid = (lt + rt) / 2;
            for(int i=N-2;i>=0;i--) {
                if (arr[temp] - arr[i] >= mid) {
                    temp = i;
                    cnt++;
                }
            }
            if (cnt < C) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
