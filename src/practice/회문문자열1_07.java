package practice;

import java.util.Scanner;

public class 회문문자열1_07 {
    public String solution(String str) {
        String answer="";
        StringBuilder s = new StringBuilder(str.toLowerCase()).reverse();
        if (s.toString().equals(str.toLowerCase())) {
            answer = "YES";
        } else {
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        회문문자열1_07 T = new 회문문자열1_07();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
