package practice;

import java.util.Scanner;

public class 피보나치수열2_04 {
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<n;i++) {
            answer[i] = answer[i-1] + answer[i-2];
        }
        return answer;
    }

    public static void main(String[] args) {
        피보나치수열2_04 T = new 피보나치수열2_04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int x : T.solution(n)) {
            System.out.print(x+" ");
        }
    }
}
