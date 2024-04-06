package practice;

import java.util.Scanner;

public class 멘토링2_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] grades = new int[M][N];
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                grades[i][j] = sc.nextInt();
            }
        }

        int[][][] cases = new int[N+1][N+1][M];

        for(int k=0;k<M;k++) {
            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    int a = grades[k][i];
                    int b = grades[k][j];

                    cases[a][b][k] = 1;
                }
            }
        }

        int answer = 0;
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                int cnt = 0;
                for(int k=0;k<M;k++) {
                    if (cases[i][j][k] == 1) cnt++;
                }
                if (cnt == M) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
