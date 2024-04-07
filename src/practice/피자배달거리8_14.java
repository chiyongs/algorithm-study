package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 피자배달거리8_14 {

    static int N, M, answer;
    static int[][] arr;
    static List<int[]> pizzas, homes;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        answer = Integer.MAX_VALUE;
        arr = new int[N][N];
        visited = new int[M];
        pizzas = new ArrayList<>();
        homes = new ArrayList<>();

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    homes.add(new int[]{i,j});
                } else if (arr[i][j] == 2) {
                    pizzas.add(new int[]{i,j});
                }
            }
        }

        comb(0, 0);
        System.out.println(answer);
    }

    static int calc(List<int[]> picks) {
        int sum = 0;
        for(int[] home : homes) {
            int min = Integer.MAX_VALUE;
            for(int [] pick : picks) {
                int distance = Math.abs(home[0] - pick[0]) + Math.abs(home[1] - pick[1]);
                min = Math.min(min, distance);
            }
            sum += min;
        }
        return sum;
    }

    static void comb(int cnt, int start) {
        if(cnt == M) {
            List<int[]> picks = new ArrayList<>();
            for(int i=0;i<M;i++) {
                picks.add(pizzas.get(visited[i]));
            }
            answer = Math.min(answer,calc(picks));
        } else {
            for(int i=start;i<pizzas.size();i++) {
                visited[cnt] = i;
                comb(cnt+1, i+1);
            }
        }
    }
}
