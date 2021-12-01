package greedy.baekjoon;

import java.util.Scanner;

public class Main {
    public int solution(String str, char t) {
        int answer = 0;
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next().toLowerCase();
        char[] sa = first.toCharArray();

        char second = sc.next().toLowerCase().charAt(0);



        int cnt = 0;
        for (int i =0; i<sa.length; i++) {
            if (sa[i] == second) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
