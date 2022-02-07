import java.util.Scanner;
import java.util.Stack;

public class Main {

	public int solution(String str) {
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		int dup = 0;
		for(char x:str.toCharArray()) {
			if(x == '(') {
				stack.push(x);
				dup++;
			}
			else if(stack.peek() == '(' && x == ')') {
				dup--;
				answer += dup;
				stack.push(x);
			}
			else if(stack.peek() == ')' && x == ')'){
				dup--;
				answer += 1;
			}
		}
		
		return answer;
	}

	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}

}
