import java.util.Scanner;

public class 등수구하기2_8 {
	public int[] solution(int n, int[] nums) {
		int[] answer = new int[n];
				
		for(int i=0;i<n;i++) {
			answer[i] = 1;
			for(int j=0;j<n;j++) {
				if(nums[j]>nums[i]) {
					
					answer[i]++;
				}
			}
		}
				
		return answer;

	}

	public static void main(String[] args) {
		등수구하기2_8 T = new 등수구하기2_8();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = kb.nextInt();
		}
		for(int x: T.solution(n, nums)) {
			System.out.print(x+" ");
		}
	}
}
