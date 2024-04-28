package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_S4_4396_지뢰찾기 {

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        List<int[]> mines = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for(int j=0;j<n;j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '*') mines.add(new int[]{i,j});
            }
        }

        char[][] answer = new char[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(answer[i], '.');
        }
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for(int j=0;j<n;j++) {
                char ch = str.charAt(j);
                if (ch == 'x') {
                    if (map[i][j] == '.') {
                        int cnt = 0;
                        for(int d=0;d<8;d++) {
                            int dx = i + dir[d][0];
                            int dy = j + dir[d][1];

                            if (0 <= dx && dx < n && 0 <= dy && dy < n && map[dx][dy] == '*') {
                                cnt++;
                            }
                        }
                        answer[i][j] = String.valueOf(cnt).charAt(0);
                    } else {
                        for(int[] mine : mines) {
                            answer[mine[0]][mine[1]] = '*';
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
