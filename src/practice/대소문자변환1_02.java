package practice;

import java.util.Scanner;

public class 대소문자변환1_02 {
    public String solution(String str) {
        StringBuilder answer = new StringBuilder(str);
        for (int i=0; i<str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                answer.setCharAt(i, Character.toUpperCase(str.charAt(i)));
            } else if(Character.isUpperCase(str.charAt(i))){
                answer.setCharAt(i, Character.toLowerCase(str.charAt(i)));
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        대소문자변환1_02 T = new 대소문자변환1_02();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
