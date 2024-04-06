package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 공통원소구하기3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;i++) {
            a[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] b = new int[M];
        for(int i=0;i<M;i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> list = new ArrayList<>();
        int p1=0,p2=0;
        while(p1 < N && p2 < M) {
            if (a[p1] < b[p2]) {
                p1++;
            } else if (a[p1] > b[p2]) {
                p2++;
            } else {
                list.add(a[p1++]);
                p1++;
            }
        }

        for(int x : list) {
            System.out.print(x + " ");
        }

    }
}
