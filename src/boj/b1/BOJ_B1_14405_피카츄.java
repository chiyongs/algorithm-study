package boj.b1;

import java.util.Scanner;
/**
 * @author chiyongs
 * @since 2022. 10. 21.
 * @see https://www.acmicpc.net/problem/14405
 * @performance 12824	104
 * @category #문자열
 * @note
 */
public class BOJ_B1_14405_피카츄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        input = input.replaceAll("pi|ka|chu", "");

        if(input.equals("")) System.out.println("YES");
        else System.out.println("NO");
    }
}
