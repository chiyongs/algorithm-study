package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S3_17413_단어뒤집기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '<') {
                flag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(ch);
            }
            else if (ch == '>') {
                flag = false;
                sb.append(ch);
            }
            else if (ch == ' ') {
                if (!flag) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
                sb.append(" ");
            } else {
                if (flag) {
                    sb.append(ch);
                } else {
                    stack.push(ch);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
