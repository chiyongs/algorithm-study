import java.util.Scanner;

public class 재귀함수7_1 {
	public void solution(int n) {
		if(n==0) return;
		
		solution(n-1);
		System.out.print(n+" ");
	}

	public static void main(String[] args) {
		재귀함수7_1 T = new 재귀함수7_1();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		T.solution(n);
	}
}
