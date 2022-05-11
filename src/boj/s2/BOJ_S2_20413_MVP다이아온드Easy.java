package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 11.
 * @see https://www.acmicpc.net/problem/20413
 * @performance 11524	88
 * @category #그리디
 * @note
 */
public class BOJ_S2_20413_MVP다이아온드Easy {

	static Map<Character, Integer> gradeInfo;
	static int[] spendMoney;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		spendMoney = new int[N + 1];
		gradeInfo = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			char grade = '0';
			int price = Integer.parseInt(st.nextToken());
			if (i == 0)
				grade = 'B';
			else if (i == 1)
				grade = 'S';
			else if (i == 2)
				grade = 'G';
			else if (i == 3)
				grade = 'P';
			gradeInfo.put(grade, price);
		}

		gradeInfo.put('D', gradeInfo.get('P'));

		char[] ranks = br.readLine().toCharArray();

		for (int i = 0; i < ranks.length; i++) {
			maxPrice(ranks[i], i + 1);
		}

		int total = 0;
		for (int i = 1; i <= N; i++) {
			total += spendMoney[i];
		}

		System.out.println(total);

	}

	private static void maxPrice(char rank, int month) {
		if (month == 1) {
			if(rank=='D') {
				spendMoney[month] = gradeInfo.get(rank);
			} else spendMoney[month] = gradeInfo.get(rank) - 1;
		} else {
			if (rank == 'D') {
				int totalSpend = gradeInfo.get(rank);
				spendMoney[month] = totalSpend;
			} else {
				int totalSpend = gradeInfo.get(rank) - 1;
				spendMoney[month] = totalSpend - spendMoney[month - 1];
			}
		}

	}
}
