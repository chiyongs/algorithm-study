package boj.b1;

import java.util.Scanner;

/**
 * @author chiyongs
 * @since 2022. 7. 22.
 * @see https://www.acmicpc.net/problem/1032
 * @performance 12940	120
 * @category #구현
 * @note
 */
public class BOJ_B1_1032_명령프롬프트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] str = new String[N];

        for(int i=0;i<N;i++) {
            str[i] = sc.next();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str[0].length();i++) {
            boolean flag = false;
            char c = str[0].charAt(i);
            for(int j=0;j<N;j++) {
                if(str[j].charAt(i) != c) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                sb.append("?");
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}
