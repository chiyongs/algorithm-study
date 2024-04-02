package practice;

import java.util.Scanner;

public class 합이같은부분집합8_1 {

    static boolean[] visited;
    static int[] arr;
    static int N;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        flag = false;
        arr = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=1;i<=N/2;i++) {
            dfs(0, i);
            if (flag) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    static void dfs(int cnt, int num) {
        if (cnt == num) {
            int a = 0, b= 0;
            for(int i=0;i<N;i++) {
                if (visited[i]) a+= arr[i];
                else b+=arr[i];
            }

            if (a==b) flag = true;
            return;
        }

        for(int i=0;i<N;i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cnt+1, num);
                visited[i] = false;
            }
        }
    }
}
