package practice;

import java.util.Scanner;

public class 문자찾기1_01 {
    public int solution(String str, char t) {
        int answer= 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
//        for(int i =0; i<str.length(); i++){
//            if (str.charAt(i) == t) {
//                answer++;
//            }
//        }

        for(char x : str.toCharArray()) {
            if (x == t) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        문자찾기1_01 T= new 문자찾기1_01();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}
