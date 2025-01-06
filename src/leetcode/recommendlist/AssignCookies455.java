package leetcode.recommendlist;

import java.util.Arrays;

public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gIdx = 0;
        int sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (gIdx < g.length && s[sIdx] >= g[gIdx]) {
                gIdx++;
            }
            sIdx++;
        }

        return gIdx;
    }
}
