package boj.s4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S4_10995_별찍기19 {

    static int N;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        N = 4*(n-1) + 1;
        map = new char[N][N];
        for(int i=0;i<N;i++) {
            Arrays.fill(map[i], ' ');
        }
        draw(0, N);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void draw(int start, int size) {
        if (start > size) return;
        for(int i=start;i<size;i++) {
            map[start][i] = '*';
            map[size-1][i] = '*';
            map[i][start] = '*';
            map[i][size-1] = '*';
        }

        draw(start+2, size - 2);
    }
}
