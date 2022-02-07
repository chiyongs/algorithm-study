import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기5_5 {
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
		쇠막대기5_5 T = new 쇠막대기5_5();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
}
