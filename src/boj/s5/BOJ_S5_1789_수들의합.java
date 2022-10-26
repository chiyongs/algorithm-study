package boj.s5;

import java.util.Scanner;
/**
 * @author chiyongs
 * @since 2022. 10. 26.
 * @see https://www.acmicpc.net/problem/1789
 * @performance 12872	112
 * @category #완탐
 * @note
 */
public class BOJ_S5_1789_수들의합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long num = scan.nextLong();
        long sum = 0;
        int count = 0;

        for(int i=1; ; i++) {
            if(sum > num)	break;
            if(sum > num)	break;
            sum += i;
            count ++;
        }
        System.out.println(count-1);
        scan.close();
    }
}
