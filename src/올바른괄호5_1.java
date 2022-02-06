import java.util.Scanner;

public class 올바른괄호5_1 {
    static int top = -1;

    public String solution(String input) {
        String answer = "NO";

        char[] ch = new char[input.length()];
        for(int i=0;i<input.length();i++) {
            if(input.charAt(i) == '(') {
                push(ch, input.charAt(i));
            } else if(input.charAt(i) == ')') {
                if(top != -1 && ch[top] == '(') {
                    pop(ch);
                } else {
                    push(ch, input.charAt(i));
                }
            }
        }

        if(top == -1) return "YES";
        return answer;
    }

    public static void push(char[] ch, char x) {
        ch[++top] = x;
    }

    public static void pop(char[] ch) {
        ch[top--] = '0';
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(T.solution(input));
    }
}
