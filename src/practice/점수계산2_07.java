package practice;

import java.util.Scanner;

public class 점수계산2_07 {
	public int solution(int n, int[] nums) {
		int answer=0;
		int s = 1;
		for(int i=0;i<n;i++) {
			if(nums[i] == 0) {
				s = 0;
			}
			answer += s++;
		}
		return answer;

	}

	public static void main(String[] args) {
		점수계산2_07 T = new 점수계산2_07();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = kb.nextInt();
		}
		System.out.println(T.solution(n,nums));
		
	}

}
