package practice;

import java.util.Scanner;

public class LRU6_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();

        int[] arr = new int[s];
        for (int i = 0; i < n; i++) {
            int task = in.nextInt();
            int cacheIdx = -1;
            boolean hit = false;
            for (int j = 0; j < s; j++) {
                if (arr[j] == task) {
                    hit = true;
                    cacheIdx = j;
                }
            }
            if (!hit) {
                for(int j=s-1;j>0;j--) {
                    arr[j] = arr[j-1];
                }
                arr[0] = task;
            } else {
                for(int j=cacheIdx;j>0;j--) {
                    arr[j] = arr[j-1];
                }
                arr[0] = task;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
