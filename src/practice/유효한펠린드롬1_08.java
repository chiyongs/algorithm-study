package practice;

import java.util.Scanner;

public class 유효한펠린드롬1_08 {
    public String solution(String str) {
        String answer="NO";
        char[] c = str.toCharArray();
        String s = "";
        for (char x : c){
            if (Character.isAlphabetic(x)) s+= x;
        }
        String v = new StringBuilder(s).reverse().toString();
        if (s.equalsIgnoreCase(v)) answer="YES";
        return answer;
    }

    public static void main(String[] args) {
        유효한펠린드롬1_08 T = new 유효한펠린드롬1_08();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
