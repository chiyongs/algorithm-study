package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 11.
 * @see https://www.acmicpc.net/problem/2493
 * @performance 107916	756
 * @category #스택
 * @note 
 */
public class BOJ_G5_2493_탑 {

	static class Tower {
		int no, height;

		public Tower(int no, int height) {
			this.no = no;
			this.height = height;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Stack<Tower> towers = new Stack<>();

		for (int i = 1; i <= N; i++) {
			int tower = Integer.parseInt(st.nextToken());

			if (i == 1) {
				towers.add(new Tower(i, tower));
				sb.append("0 ");
			} else {
				while (!towers.isEmpty()) {
					if (towers.peek().height > tower) {
						sb.append(towers.peek().no).append(" ");
						towers.add(new Tower(i, tower));
						break;
					} else {
						towers.pop();
					}
				}
				if(towers.isEmpty()) {
					sb.append("0 ");
					towers.add(new Tower(i,tower));
				}
			}

		}

		System.out.println(sb);
	}
}
