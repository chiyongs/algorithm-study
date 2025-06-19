package leetcode.recommendlist;

import java.util.Stack;

public class SplitAStringInBalancedStrings1221 {
    public int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (top == ch) {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ch);
                cnt++;
            }
        }
        return cnt;
    }
}
