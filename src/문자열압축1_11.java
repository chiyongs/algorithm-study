import java.util.Scanner;

public class 문자열압축1_11 {
    public String solution(String str) {
        String answer = "";
        char[] c = (str+" ").toCharArray();
        char t = str.charAt(0);
        answer += t;
        int count = 0;
        for (char x: c) {
            if (t == x) count++;
            else {
                if (count != 1) answer = answer + String.valueOf(count) + x;
                else answer += x;
                t = x;
                count = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        문자열압축1_11 T = new 문자열압축1_11();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
