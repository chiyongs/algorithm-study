package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S4_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			if(input.equals(".")) {
				break;
			}			

			for(int i=0,size=input.length();i<size;i++) {
				if(input.charAt(i) == '(' || input.charAt(i) == '[') {
					stack.push(input.charAt(i));
				}
				else if(input.charAt(i) == ')') {
					if(stack.isEmpty()) {
						stack.push(')');
					} else {
						if(stack.peek() == '(') {
							stack.pop();
							continue;
						} else {
							stack.push(input.charAt(i));
							break;
						}
							
					}
				} else if(input.charAt(i) == ']') {
					if(stack.isEmpty()) {
						stack.push(']');
					} else {
						if(stack.peek() == '[') {
							stack.pop();
							continue;
						} else {
							stack.push(input.charAt(i));
							break;
						}
					}
				}				
			}
			
			if(stack.isEmpty()) sb.append("yes\n");
			else sb.append("no\n");
		}
		System.out.println(sb.toString());
	}
}
