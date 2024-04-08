package practice;

import java.util.Arrays;
import java.util.Scanner;

public class 씨름선수9_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] applicants = new int[N][2];
        for(int i=0;i<N;i++) {
            applicants[i][0] = sc.nextInt();
            applicants[i][1] = sc.nextInt();
        }

        Arrays.sort(applicants, (a1, a2) -> a2[0] - a1[0]);

        int cnt = 1;
        int w = applicants[0][1];
        for(int i=1;i<N;i++) {
            if (applicants[i][1] > w) {
                w = applicants[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
