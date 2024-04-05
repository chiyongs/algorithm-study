package practice;

import java.util.Arrays;
import java.util.Scanner;

public class 중복순열구하기8_4 {

    static int[] visited;
    static int n,r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();

        visited = new int[r];
        dupPerm(0);
    }

    static void dupPerm(int cnt) {
        if (cnt == r) {
            System.out.println(Arrays.toString(visited));
            return;
        }
        for(int i=1;i<=n;i++) {
            visited[cnt] = i;
            dupPerm(cnt+1);
        }
    }
}
