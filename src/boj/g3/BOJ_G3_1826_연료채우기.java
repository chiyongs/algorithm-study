package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 29.
 * @see https://www.acmicpc.net/problem/1826
 * @performance 21632	336
 * @category #그리디 #우선순위 큐 #정렬
 * @note 
 * 		 
 */
public class BOJ_G3_1826_연료채우기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> stations = new PriorityQueue<>((o1,o2) -> {
			return Integer.compare(o1[0], o2[0]);
		}) ;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			stations.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int home = Integer.parseInt(st.nextToken());
		int have = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int index = 0;
		int answer = 0;
		while(have < home) {
			while(index<N && stations.peek()[0] <= have) {
				pq.offer(stations.poll()[1]);
				index++;
			}
			
			if(pq.isEmpty()) {
				System.out.println(-1);
				return;
			}
			
			
			have += pq.poll();
			answer++;
			
		}
		
		System.out.println(answer);
		
		
	}
	
	

}
