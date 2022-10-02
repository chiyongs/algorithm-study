package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 10. 2
 * @see https://www.acmicpc.net/problem/1043
 * @performance 11648	80
 * @category #union-find
 * @note
 */
public class BOJ_G4_1043_거짓말 {

    static int[] parents;
    static boolean[] truth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        init(N);

        st = new StringTokenizer(br.readLine()," ");
        int cnt = Integer.parseInt(st.nextToken());
        for(int i=0;i<cnt;i++) {
            int no = Integer.parseInt(st.nextToken());
            truth[no] = true;
        }

        List<int[]> parties = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int attendCnt = Integer.parseInt(st.nextToken());

            if(attendCnt == 0) continue;

            int[] party = new int[attendCnt];
            int attendNo = Integer.parseInt(st.nextToken());
            party[0] = attendNo;
            for(int j=0;j<attendCnt-1;j++) {
                int attN = Integer.parseInt(st.nextToken());
                party[j+1] = attN;
                union(attendNo, attN);
            }

            parties.add(party);
        }

        boolean[] visited = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            if(truth[i] && !visited[i]) {
                int root = findParent(i);
                for(int j=1;j<=N;j++) {
                    if(root == findParent(j)) {
                        truth[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for(int[] party : parties) {
            int c = 0;
            for(int no : party) {
                if(truth[no]) c++;
            }
            if(c == 0) answer++;
        }

        System.out.println(answer);
    }

    private static void init(int n) {
        parents = new int[n+1];
        for(int i=1;i<=n;i++) {
            parents[i] = i;
        }
        truth = new boolean[n+1];
    }

    private static int findParent(int a) {
        if(parents[a] == a) return a;
        return parents[a] = findParent(parents[a]);
    }

    private static void union(int a, int b) {
        int aRoot = findParent(a);
        int bRoot = findParent(b);

        if(aRoot != bRoot) parents[bRoot] = aRoot;
    }

}
