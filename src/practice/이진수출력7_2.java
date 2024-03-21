package practice;

import java.util.Scanner;

public class 이진수출력7_2 {
	public String solution(int n) {
		return Integer.toBinaryString(n);
	}

	public static void main(String[] args) {
		이진수출력7_2 T = new 이진수출력7_2();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(T.solution(n));
	}
}
