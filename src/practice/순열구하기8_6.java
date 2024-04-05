package practice;

import java.util.Arrays;
import java.util.Scanner;

public class 순열구하기8_6 {

    static int N,M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        visited = new boolean[N+1];
        perm(0);
    }

    static void perm(int cnt) {
        if (cnt==M) {
            System.out.println(Arrays.toString(arr));
            return;
        }
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
