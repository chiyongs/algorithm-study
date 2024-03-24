package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 임시반장정하기2_10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] students = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                students[i][j] = in.nextInt();
            }
        }

        boolean[][] arr = new boolean[n][n];

        for (int grade = 0; grade < 5; grade++) {
            for (int studentNo = 0; studentNo < n; studentNo++) {
                for(int i=0;i<n;i++) {
                    if (studentNo == i) continue;
                    if (students[studentNo][grade] == students[i][grade]) {
                        arr[studentNo][i] = true;
                        arr[i][studentNo] = true;
                    }
                }
            }
        }

        int[] maxArr = new int[n];
        int max = 0;
        for(int i=0;i<n;i++) {
            int cnt = 0;
            for(int j=0;j<n;j++) {
                if (arr[i][j]) cnt++;
            }
            if (cnt > max) {
                max = cnt;
                maxArr[i] = max;
            }
        }
        for(int i=0;i<n;i++) {
            if (maxArr[i] == max) {
                System.out.println(i+1);
                return;
            }
        }

    }
}
