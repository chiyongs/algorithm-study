import java.util.Scanner;
import java.util.Stack;

public class 후위식연산5_4 {
	public int solution(String str) {
		Stack<Integer> stack = new Stack<>();
		for(char x:str.toCharArray()) {
			if(Character.isDigit(x)) {
				stack.push(x-'0');
			} else {
				int b = stack.pop();
				int a = stack.pop();
				switch(x) {
				case '+':
					stack.push(a+b);
					break;
				case '-':
					stack.push(a-b);
					break;
				case '*':
					stack.push(a*b);
					break;
				case '/':
					stack.push(a/b);
					break;
				}
			}
		}
		
		return stack.peek();
	}

	
	public static void main(String[] args) {
		후위식연산5_4 T = new 후위식연산5_4();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
}
