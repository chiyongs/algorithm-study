package practice;

import java.util.Scanner;

public class 가장짧은문자거리1_10 {
    public int[] solution(String s, char c) {
        /*
        int[] n = new int[s.length()];
        for(int i=0; i<s.length();i++) {
            if (s.charAt(i) == c) n[i] = 0;
            else n[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<s.length();i++) {
            if (n[i]!=0) {
                int m= 0;
                for(int j=0;j<s.length();j++) {
                    if (n[j] == 0) {
                        if (i > j) m = i-j;
                        else m  = j-i;
                        if (n[i] - m > 0) {
                            n[i] = m;
                        }
                    }

                }
            }
        }
        return n;
        */
        int[] n = new int[s.length()];
        int p = 1000;
        for(int i=0; i<s.length();i++) {
            if (s.charAt(i) == c) {
                p = 0;
                n[i] = p;
            } else {
                p++;
                n[i] = p;
            }
        }
        for(int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i)==c) p=0;
            else {
                p++;
                n[i] = Math.min(n[i], p);
            }
        }

        return n;

    }

    public static void main(String[] args) {
        가장짧은문자거리1_10 T = new 가장짧은문자거리1_10();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        for (int n : T.solution(str, c)) {
            System.out.print(n+" ");
        }
    }
}
