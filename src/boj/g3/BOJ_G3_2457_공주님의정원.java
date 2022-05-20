package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 20.
 * @see https://www.acmicpc.net/problem/2457
 * @performance 51784	544
 * @category #그리디
 * @note 
 * 		 
 */
public class BOJ_G3_2457_공주님의정원 {
	
	static class Flower implements Comparable<Flower> {
		int start, end;
		
		public Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Flower o) {
			if(this.start == o.start) return o.end - this.end;
			return this.start - o.start;
		}		
		
	}

	static int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		List<Flower> flowers = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			if(startMonth < 3) {
				startMonth = 3;
				startDay = 1;
			}
			
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			
			int start = calculateDate(startMonth, startDay);
			int end = calculateDate(endMonth,endDay);
			
			flowers.add(new Flower(start, end));
		}
		
		Collections.sort(flowers);
		
		int answer = 0;
		
		int timeEnd = 1;
		
		int max = 0;
		int index = 0;
		while(timeEnd < 276) {
			boolean flag = false;
			
			for(int i=index;i<N;i++) {
				if(flowers.get(i).start > timeEnd) break;
				
				if(flowers.get(i).end > max) {
					max = flowers.get(i).end;
					flag = true;
					index = i+1;
				}
			}
			
			
			if(!flag) {
				System.out.println(0);
				return;
			} else {
				answer++;
				timeEnd = max;
			}
		}
		
		System.out.println(answer);

	}
	
	private static int calculateDate(int month, int day) {
		int result = 0;		
		
		for(int i=3;i<=12;i++) {
			if(i==month) {
				result += day;
				break;
			}
			result += months[i];
		}
		
		return result;
	}

}
