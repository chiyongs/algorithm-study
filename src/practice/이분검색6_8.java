package practice;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색6_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == m) {
                System.out.println(mid+1);
                return;
            } else if (arr[mid] < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

    }
}
