package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기5_6 {
	public int solution(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		int answer = 0;
		for(int i=1;i<=n;i++) {
			queue.offer(i);
		}
		int cnt = k;
		while(!(queue.isEmpty())) {
			Integer x = queue.poll();
			cnt--;
			if(cnt==0) {
				cnt = k;
			} else {
				queue.offer(x);
			}
			answer = x;
		}
		
		return answer;
	}

	
	public static void main(String[] args) {
		공주구하기5_6 T = new 공주구하기5_6();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(T.solution(n,k));
	}
}
