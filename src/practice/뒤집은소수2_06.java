package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class 뒤집은소수2_06 {
	public ArrayList<Integer> solution(int n, int[] nums) {
		ArrayList<Integer> answer = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			boolean isPrime = true;

			char[] c = String.valueOf(nums[i]).toCharArray();
			int r = 0;
			int lt = 0, rt = c.length - 1;
			while (lt < rt) {
				char tmp = c[lt];
				c[lt] = c[rt];
				c[rt] = tmp;
				lt++;
				rt--;
			}
			r = Integer.parseInt(String.valueOf(c));
			for (int j = 2; j < r - 1; j++) {
				if (r % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime && r>1) {
				answer.add(r);
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		뒤집은소수2_06 T = new 뒤집은소수2_06();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = kb.nextInt();
		}

		for (int x : T.solution(n, nums)) {
			System.out.print(x + " ");
		}
	}

}

