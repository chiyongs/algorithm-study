package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 응급실5_8 {
	public int solution(int n, int m, int[] patients) {
		Queue<Integer> P = new LinkedList<>();
		Queue<Integer[]> Q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			Q.offer(new Integer[] {(m==i) ? m : -1,patients[i]});
		}
		
		Arrays.sort(patients);
		
		for(int i=n-1;i>=0;i--) {
			P.offer(patients[i]);
		}
		int cnt = 0;
		while(!Q.isEmpty()) {
			if(Q.peek()[1] < P.peek()) {
				Q.offer(Q.poll());
			} else {
				Integer[] x = Q.poll();
				P.poll();
				cnt++;
				if(x[0] == m) {
					return cnt;
				}
			}			
		}		
		return cnt;		
	}

	public static void main(String[] args) {
		응급실5_8 T = new 응급실5_8();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] patients = new int[n];
		for (int i = 0; i < n; i++) {
			patients[i] = sc.nextInt();
		}

		System.out.println(T.solution(n, m, patients));
	}
}
