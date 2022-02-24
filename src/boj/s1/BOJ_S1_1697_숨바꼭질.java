package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 24.
 * @see https://www.acmicpc.net/problem/1697
 * @performance 17140	140
 * @category #BFS
 * @note
 */
public class BOJ_S1_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dis = new int[100001];
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(N);
		dis[N] = 0;
		
		while(!Q.isEmpty()) {
			Integer cur = Q.poll();		
			if(cur == K) {
				System.out.println(dis[cur]);
				return;
			}
			
			for(int d=0;d<3;d++) {
				int nx = 0;
				if(d==0) {
					nx = cur-1;						
				} else if(d==1) {
					nx = cur+1;					
				} else {
					nx = cur*2;				
				}
				
				if(nx<0||nx>=100001) continue;
				if(dis[nx] != 0) continue;					
				dis[nx] = dis[cur] + 1;
				Q.offer(nx);
				
			}
		}

	}

}
