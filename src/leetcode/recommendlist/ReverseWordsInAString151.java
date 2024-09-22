package leetcode.recommendlist;

import java.util.*;

public class ReverseWordsInAString151 {

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        char[] chArr = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<chArr.length;i++) {
            char ch = chArr[i];
            if (ch == ' ') {
                if (sb.length() != 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(ch);
            }
        }
        String str = sb.toString();
        if (!str.isEmpty() && !str.isBlank()) {
            stack.push(sb.toString());
        }

        sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
