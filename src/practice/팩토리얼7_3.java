package practice;

import java.util.Scanner;

public class 팩토리얼7_3 {
	public int solution(int n) {
		if(n==1) return 1;
		
		return n * solution(n-1);
	}

	public static void main(String[] args) {
		팩토리얼7_3 T = new 팩토리얼7_3();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(T.solution(n));
	}
}
