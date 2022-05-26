package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 26.
 * @see https://www.acmicpc.net/problem/2170
 * @performance 329444	2300
 * @category #그리디
 * @note 
 */
public class BOJ_G5_2170_선긋기 {
	
	static class Line implements Comparable<Line>{
		int start, end;

		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Line [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Line o) {
			if(this.start == o.start) return Integer.compare(this.end, o.end);
			return Integer.compare(this.start, o.start);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Line[] lines = new Line[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lines);
		
		int lineEnd = lines[0].end;
		int answer = lines[0].end - lines[0].start;
		
		for(int i=1;i<N;i++) {
			if(lineEnd >= lines[i].start) {
				if(lines[i].end > lineEnd) {
					answer += lines[i].end - lineEnd;
					lineEnd = lines[i].end;
				}
			} else {
				answer += (lines[i].end - lines[i].start);
				lineEnd = lines[i].end;
			}

		}
		
		System.out.println(answer);
		

	}

}
