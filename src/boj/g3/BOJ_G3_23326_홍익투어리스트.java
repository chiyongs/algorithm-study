package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author chiyongs
 * @since 2022. 5. 3.
 * @see https://www.acmicpc.net/problem/23326
 * @performance 86728	728
 * @category #이진검색트리
 * @note 정렬된 데이터 treeset treemap
 */
public class BOJ_G3_23326_홍익투어리스트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		TreeSet<Integer> tset = new TreeSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(st.nextToken());
			if (val == 1)
				tset.add(i);
		}

		int cur = 0;
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());

			if (num == 1) {
				int p = Integer.parseInt(st.nextToken()) - 1;
				if (tset.contains(p))
					tset.remove(p);
				else
					tset.add(p);
			} else if (num == 2) {
				int x = Integer.parseInt(st.nextToken());
				cur += x;
				if (cur >= N) {
					cur %= N;
				}
			} else {
				if (tset.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					Integer pos = tset.ceiling(cur);
					if (pos == null) {
						pos = tset.ceiling(0);
						sb.append(N-cur + pos).append("\n");
					} else {
						sb.append(pos-cur).append("\n");						
					}
				}

			}
		}

		System.out.println(sb.toString());

	}
}
