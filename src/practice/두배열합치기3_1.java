package practice;

import java.util.Scanner;

public class 두배열합치기3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for(int i=0;i<N;i++) {
            arr1[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for(int i=0;i<M;i++) {
            arr2[i] = sc.nextInt();
        }

        int p1 = 0,p2 = 0;
        while(p1 < N || p2 < M) {
            int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;
            if (p1 < N) {
                val1 = arr1[p1];
            }
            if (p2 < M) {
                val2 = arr2[p2];
            }

            if (val1 < val2) {
                System.out.print(val1 + " ");
                p1++;
            } else {
                System.out.print(val2 + " ");
                p2++;
            }
        }
    }
}
