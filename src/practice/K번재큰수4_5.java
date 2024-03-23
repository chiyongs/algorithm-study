package practice;

import java.util.Scanner;
import java.util.TreeSet;

public class K번재큰수4_5 {

    static int N, K;
    static int[] arr;
    static boolean[] visited;
    static TreeSet<Integer> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];

        set = new TreeSet<>((n,m) -> m-n);

        for (int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }

        for (int i=0;i<N;i++) {
            for (int j=i+1;j<N;j++) {
                for (int k=j+1;k<N;k++) {
                    set.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        int cnt = 0;
        int answer = -1;
        for (int x : set) {
            cnt++;
            if (cnt == K) answer = x;
        }
        System.out.println(answer);
    }
}
