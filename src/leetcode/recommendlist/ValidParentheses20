package leetcode.recommendlist;

import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                char top = stack.peek();
                if (top == '(') {
                    if (ch == ')') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                } else if (top == '{') {
                    if (ch == '}') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                } else if (top == '[') {
                    if (ch == ']') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
