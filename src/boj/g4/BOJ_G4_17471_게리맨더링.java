package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 6.
 * @see https://www.acmicpc.net/problem/17471
 * @performance 15636	108
 * @category #백트래킹 #구현
 * @note
 */
public class BOJ_G4_17471_게리맨더링 {

	static boolean[] isSelected;
	static int N,graph[][], population[], answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		population = new int[N+1];
		answer = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new int[N+1][N+1];
		isSelected = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++) {
				int to = Integer.parseInt(st.nextToken());
				graph[i][to] = 1;
			}
		}
		
		chooseSector(1);
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {			
			System.out.println(answer);
		}
		
	}
	
	private static void chooseSector(int cnt) {
		if(cnt==N+1) {
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			
			for(int i=1;i<=N;i++) {
				if(isSelected[i]) A.add(i);
				else B.add(i);
			}
			
			if(A.isEmpty() || B.isEmpty()) {
				return;
			}		
			
			if(isConnect(A, new boolean[N+1], A.get(0), 0) &&
					isConnect(B, new boolean[N+1], B.get(0), 0)) {				
				int pop_a = 0, pop_b =0;
				for(int a: A) {
					pop_a += population[a];
				}
				for(int b:B) {
					pop_b += population[b];
				}
				
				int result = Math.abs(pop_a - pop_b);
				
				if(answer > result) {
					answer= result;
				}
			}
			
			return;
		}
		
		isSelected[cnt] = true;
		chooseSector(cnt+1);
		isSelected[cnt] = false;
		chooseSector(cnt+1);
	}
	
	private static boolean isConnect(List<Integer> sector, boolean[] visited, int cur, int cnt) {
		if(cnt == sector.size()) {
			return true;
		}
		visited[cur] = true;
		
		for(int s : sector) {
			if(s != cur) {
				if(graph[cur][s] == 1 && !visited[s]) {
					isConnect(sector, visited, s,cnt+1);
				}
			}
		}
		
		for(int s : sector) {
			if(!visited[s]) return false;
		}
		return true;
	}

}
