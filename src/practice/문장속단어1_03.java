package practice;

import java.util.Scanner;

public class 문장속단어1_03 {
    public String solution(String str) {
        String answer = str;
        String[] s = answer.split(" ");
        int m = Integer.MIN_VALUE;
        for (String s1 : s) {
            if (s1.length() > m) {
                m = s1.length();
                answer = s1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        문장속단어1_03 T = new 문장속단어1_03();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
