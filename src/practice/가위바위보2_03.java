package practice;

import java.util.Scanner;

public class 가위바위보2_03 {
    public char[] solution(int n, int[] a, int[] b) {
        char[] answer = new char[n];
        for (int i=0;i<n;i++) {
            if(a[i] < b[i]) {
                answer[i] = 'B';
                if(b[i] - a[i] > 1) {
                    answer[i] ='A';
                }
            } else if (b[i] < a[i]) {
                answer[i] = 'A';
                if (a[i] - b[i] > 1) {
                    answer[i] = 'B';
                }
            } else answer[i] = 'D';
        }
        return answer;
    }

    public static void main(String[] args) {
        가위바위보2_03 T = new 가위바위보2_03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n;i++) {
            a[i] = kb.nextInt();
        }
        for(int i=0; i<n;i++) {
            b[i] = kb.nextInt();
        }
        for(char x : T.solution(n, a, b)) {
            System.out.println(x);
        }
    }
}
