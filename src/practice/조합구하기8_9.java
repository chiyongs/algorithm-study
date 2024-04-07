package practice;

import java.util.Scanner;

public class 조합구하기8_9 {

    static int n,m, arr[];
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        arr = new int[m];
        comb(0, 1);
    }

    static void comb(int cnt, int start) {
        if (cnt == m) {
            for(int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i=start;i<=n;i++) {
                arr[cnt] = i;
                comb(cnt+1, i+1);
            }
        }
    }
}
