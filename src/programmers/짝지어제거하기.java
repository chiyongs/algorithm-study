package programmers;

import java.util.Stack;

public class 짝지어제거하기 {

    public static void main(String[] args) {
        짝지어제거하기 j = new 짝지어제거하기();
        System.out.println(j.solution("baabaa"));
    }

    public int solution(String s) {
        int lt = 0, rt = lt + 1;
        char[] arr = s.toCharArray();

        int start = 0;
        while(rt < s.length()) {
            if (arr[lt] == arr[rt]) {
                if (lt == start) {
                    arr[lt] = ' ';
                    arr[rt] = ' ';
                    start = rt+1;
                    lt = rt+1;
                    rt += 2;
                } else {
                    arr[lt] = ' ';
                    arr[rt] = ' ';
                    lt--;
                    rt++;
                }
            } else {
                lt++;
                rt++;
            }
        }

        for(int i=0;i<s.length();i++) {
            if (arr[i] != ' ') return 0;
        }
        Stack<Character> stack = new Stack<>();
        return 1;
    }
}
