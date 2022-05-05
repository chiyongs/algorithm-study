package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 5.
 * @see https://www.acmicpc.net/problem/20055
 * @performance 15716	228
 * @category #구현
 * @note
 */
public class BOJ_G5_20055_컨베이어벨트위의로봇 {

    static int[] belt;
    static boolean[] visited;
    static int N, K, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[N * 2];
        visited = new boolean[N * 2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int[] upside = new int[N];
        for (int i = 1; i < N; i++) {
            upside[i] = i - 1;
        }
        upside[0] = N * 2 - 1;

        visited[upside[0]] = true;
        belt[upside[0]]--;
        if (belt[upside[0]] == 0) {
            cnt++;
        }
        int step = 1;
        while (cnt < K) {
            step++;

            if (visited[upside[N - 1]]) visited[upside[N - 1]] = false;
            for (int i = 0; i < N; i++) {
                if (upside[i] == 0) upside[i] = N * 2 - 1;
                else upside[i]--;
            }

            if (visited[upside[N - 1]]) visited[upside[N - 1]] = false;

            for (int i = N - 2; i >= 0; i--) {
                int cur = upside[i];
                int next = upside[i + 1];

                if (visited[cur] && !visited[next] && belt[next] > 0) {
                    visited[cur] = false;
                    visited[next] = true;
                    belt[next]--;
                    if (belt[next] == 0) cnt++;
                    if (next == upside[N - 1]) visited[next] = false;
                }
            }

            if (belt[upside[0]] > 0) {
                visited[upside[0]] = true;
                belt[upside[0]]--;
                if (belt[upside[0]] == 0) cnt++;
            }

        }

        System.out.println(step);

    }

}
