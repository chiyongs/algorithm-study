package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author chiyongs
 * @since 2022. 4. 27.
 * @see https://www.acmicpc.net/problem/1202
 * @performance 131708	1232
 * @category #우선순위 큐 #TreeMap
 * @note key에 대한 갯수를 value에 담는다.
 */
public class BOJ_G2_1202_보석도둑 {

	static class Jewelry implements Comparable<Jewelry> {
		int m, v;

		public Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewelry o) {
			return Integer.compare(this.v, o.v) * -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Jewelry> pq = new PriorityQueue<>(); // 보석을 내림차순으로 담는 우선순위 큐
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq.add(new Jewelry(m, v));
		}

		TreeMap<Integer, Integer> tmap = new TreeMap<>(); // 가방의 정보를 담는 TreeMap

		for (int i = 0; i < K; i++) {
			int c = Integer.parseInt(br.readLine());
			tmap.put(c, tmap.getOrDefault(c, 0)+1); // key에는 담을수 있는 무게, value에는 그 무게의 가방 갯수
		}

		long answer = 0;
		
		while(!pq.isEmpty()) {
			Jewelry cur = pq.poll();
			
			Integer bm = tmap.ceilingKey(cur.m); // 현재 보석을 담을 수 있는 같거나 큰 가방 중 가장 작은 무게의 가방
			if(bm == null) continue; // null이면 보석을 담을 수 있는 가방이 없으므로 continue
			
			answer += cur.v; // 보석을 담았으므로 가치 합산
			if(tmap.put(bm, tmap.get(bm) -1) == 1) { // 해당 가방의 갯수가 1개이면
				tmap.remove(bm); // 해당 가방 삭제
			}
			
		}
		
		System.out.println(answer);

	}

}
