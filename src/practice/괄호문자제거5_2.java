package practice;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거5_2 {
	public String solution(String input) {
		Stack<Character> stack = new Stack<>();
		String answer = "";
		
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i) == ')') {
				while(stack.pop() != '(') {
				}
			} else {
				stack.push(input.charAt(i));
			}
		}
		
		while(!stack.isEmpty()) {
			answer = stack.pop() + answer;
		}
		return answer;
	}

	
	public static void main(String[] args) {
		괄호문자제거5_2 T = new 괄호문자제거5_2();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		System.out.println(T.solution(input));
	}
}
