package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * @author chiyongs
 * @since 2022. 5. 25.
 * @see https://www.acmicpc.net/problem/15903
 * @performance 12992	136
 * @category #그리디
 * @note 
 * 		 
 */
public class BOJ_S2_15903_카드합체놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0;i<m;i++) {
			long a = pq.poll();
			long b = pq.poll();
			
			long sum = a+b;
			pq.offer(sum);
			pq.offer(sum);
		}

		long answer = 0;
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		
		System.out.println(answer);
	}

}
