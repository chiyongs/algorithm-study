package practice;

import java.util.Scanner;

public class 보이는학생2_02 {
    public int solution(int n, int[] num) {
        int answer = 1;
        int m = num[0];
        for(int i=1;i<n;i++) {
            if(num[i] > m) {
                answer++;
                m = num[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        보이는학생2_02 T = new 보이는학생2_02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n;i++) {
            num[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, num));
    }
}
