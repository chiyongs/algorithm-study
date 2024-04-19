package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S4_9012_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int i=0;i<s.length();i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if (!stack.isEmpty()) stack.pop();
                    else {
                        stack.push(')');
                        break;
                    }
                }
            }

            if (stack.isEmpty()) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
