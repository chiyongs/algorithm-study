package leetcode.recommendlist;

import java.util.*;

public class Combination77 {

    public static void main(String[] args) {
        Combination77 c = new Combination77();
        List<List<Integer>> result = c.combine(4, 2);
        System.out.println(result);
    }

    static boolean[] visited;
    static List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        visited = new boolean[n+1];
        result = new ArrayList<>();
        combination(0, 1, n, k);
        return result;
    }

    void combination(int cnt, int start, int n, int k) {
        if (cnt == k) {
            List<Integer> temp = new ArrayList<>();
            for (int num=1;num<=n;num++) {
                if (visited[num]) temp.add(num);
            }
            result.add(temp);
        }
        for(int i=start;i<=n;i++) {
            visited[i] = true;
            combination(cnt+1, i+1, n, k);
            visited[i] = false;
        }
    }
}
