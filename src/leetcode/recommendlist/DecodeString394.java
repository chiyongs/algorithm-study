package leetcode.recommendlist;

import java.util.*;

public class DecodeString394 {
    public String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c != ']') {
                stack.push(c);
            }
            else {
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                String sub = sb.toString();
                stack.pop();

                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                int count = Integer.valueOf(sb.toString()); //this is the number

                while(count > 0) {
                    for(char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        StringBuilder retv = new StringBuilder();
        while(!stack.isEmpty()) {
            retv.insert(0, stack.pop());
        }
        return retv.toString();
    }
}
