package leetcode.recommendlist;

import java.util.*;

public class GenerateParentheses22 {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        go(n, 1, 0, sb);
        return result;
    }

    void go(int n, int leftCnt, int rightCnt, StringBuilder sb) {
        if (sb.length() == n*2) {
            result.add(sb.toString());
            return;
        }

        if (leftCnt < n) {
            sb.append("(");
            go(n, leftCnt+1, rightCnt, sb);
            sb.deleteCharAt(sb.length() -1);
        }
        if (leftCnt > rightCnt) {
            sb.append(")");
            go(n, leftCnt, rightCnt+1, sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
