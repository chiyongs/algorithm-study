package boj.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 13.
 * @see https://www.acmicpc.net/problem/16496
 * @performance 16804	120
 * @category #문자열
 * @note 
 */
public class BOJ_P5_16496_큰수만들기 {
	
	static class MyNum implements Comparable<MyNum>{
		int original;
		String modified;
		
		public MyNum(int o, String m) {
			this.original = o;
			this.modified = m;
		}
		
		public int compareTo(MyNum o) {
			StringBuilder A = new StringBuilder();
			A.append(modified).append(o.modified);
			StringBuilder B = new StringBuilder();
			B.append(o.modified).append(modified);
			
			return B.toString().compareTo(A.toString());
		}
		
	}
	
	static int maxLen;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		List<MyNum> list = new ArrayList<>();
		maxLen = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			String value = st.nextToken();
			if(value.length() > maxLen) maxLen = value.length();
			list.add(new MyNum(Integer.parseInt(value),value));
		}
		
		Collections.sort(list);
		
		for(int i=0;i<N;i++) {
			if(i==0) {
				if(list.get(i).original == 0) {
					System.out.println("0");
					return;
				}
			}
			sb.append(list.get(i).original);
		}
		
		System.out.println(sb);
	}

}
