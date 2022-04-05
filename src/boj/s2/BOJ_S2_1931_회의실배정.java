package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 4.
 * @see https://www.acmicpc.net/problem/1931
 * @performance 42800	468
 * @category #그리디
 * @note
 */
public class BOJ_S2_1931_회의실배정 {
	
	static class Task implements Comparable<Task>{
		int start, end;
		
		public Task(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Task o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Task[] tasks = new Task[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(tasks);
		int answer = 1;
		int time = tasks[0].end;
		
		for(int i=1;i<n;i++) {
			if(time <= tasks[i].start) {
				answer++;
				time = tasks[i].end;
			}
		}
		
		System.out.println(answer);		
		
	}

}
