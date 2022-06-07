package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 27.
 * @see https://www.acmicpc.net/problem/1911
 * @performance 17236	336
 * @category #그리디
 * @note 
 */
public class BOJ_S1_1911_흙길보수하기 {

	static class Spot implements Comparable<Spot> {
		int start, end;

		public Spot(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Spot o) {
			if (this.start == o.start)
				return Integer.compare(this.end, o.end) * -1;
			return Integer.compare(this.start, o.start);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		List<Spot> spots = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			spots.add(new Spot(start, end));
		}

		Collections.sort(spots);

		int answer = 0;
		int built = 0;
		for(int i=0;i<N;i++) {
			if(spots.get(i).start > built) {
				built = spots.get(i).start;
			}
			
			while(built < spots.get(i).end) {
				built += L;
				answer++;
			}
		}

		System.out.println(answer);

	}

}
