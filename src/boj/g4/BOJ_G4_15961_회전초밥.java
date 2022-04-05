package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 5.
 * @see https://www.acmicpc.net/problem/15961
 * @performance 168572	492
 * @category #슬라이딩 윈도우 #투포인터
 * @note
 */
public class BOJ_G4_15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int start = 0, end = k, answer = 0,temp=0;
		int[] status = new int[d+1];
		for(int i=start;i<end;i++) {
			if(status[sushi[i]] == 0) answer++;
			status[sushi[i]]++;
		}
		
		if(status[c] == 0) {
			answer++;
			temp = answer-1;
		} else {
			temp = answer;
		}
		
		start++;
		
		while(start < N) {
			if(end >= N) {
				end = end % N;
			}
			if(status[sushi[start-1]] == 1) {
				temp--;
			}
			status[sushi[start-1]]--;
			if(status[sushi[end]] == 0) {
				temp++;
			}
			status[sushi[end]]++;
			if(temp >= answer) {
				answer= temp;
				if(status[c] == 0) {
					answer++;
				}
			}
			
			start++;
			end++;
		}
		
		
		System.out.println(answer);
		

	}

}
