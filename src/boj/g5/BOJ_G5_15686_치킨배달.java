package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 23.
 * @see https://www.acmicpc.net/problem/15686
 * @performance 26484	248
 * @category #그래프로 풀어야하나 고민했지만 결국은 조합문제!
 * @note
 */

public class BOJ_G5_15686_치킨배달 {	
	
	static int N,M;	
	static List<Integer[]> chickens;
	static List<Integer[]> houses;	
	static Integer[][] checked;
	static int minD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		chickens = new ArrayList<>();
		houses = new ArrayList<>();
		minD = Integer.MAX_VALUE;
		
		for(int r=1;r<=N;r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=1;c<=N;c++) {
				int loc = Integer.parseInt(st.nextToken());
				if(loc == 2) chickens.add(new Integer[] {r,c});
				else if(loc == 1) houses.add(new Integer[] {r,c});
				map[r][c] = loc;
			}
		}
		
		checked = new Integer[M][2];
		
		combination(0,0);
		
		System.out.println(minD);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt==M) {
			int sum = 0;
			int[][] temp = new int[houses.size()][M];
			int[] h = new int[houses.size()];
			for(int i=0,size=houses.size();i<size;i++) {
				for(int j=0;j<M;j++) {
					int d = Math.abs(checked[j][0] - houses.get(i)[0]) + 
							Math.abs(checked[j][1] - houses.get(i)[1]);

					// 한 집에서의 각 치킨집들까지의 거리
					temp[i][j] = d;
				}
			}
			
			for(int i=0,size=houses.size();i<size;i++) {					
				int min = Integer.MAX_VALUE;
				for(int j=0;j<M;j++) {	
					min = Math.min(min, temp[i][j]);				
				}
				h[i] = min;
				sum += min;
			}			
			
			if(sum < minD) {
				minD = sum;				
			}						
			return;
		}
		
		for(int i=start,size=chickens.size();i<size;i++) {
			checked[cnt] = chickens.get(i);
			combination(cnt+1, i+1);			
		}
	}
	
	
}
