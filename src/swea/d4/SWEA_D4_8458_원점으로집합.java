package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_8458_원점으로집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int mod = -1;
			int maxGap = Integer.MIN_VALUE;
			boolean notSameMod = false;
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int gap = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
				if(i==0) {
					mod = gap%2;
					maxGap = gap;
				} else {
					if(mod!=gap%2) {
						notSameMod = true;
					} else {
						maxGap = Math.max(maxGap, gap);
					}
				}
				
			}
			
			int answer = 0;
			if(notSameMod) {
				answer = -1;
			} else {
				while(maxGap>0) {
					answer++;
					maxGap -= answer;
				}
				maxGap*= -1;
				
				if(maxGap % 2 == 1) {
					if(answer % 2 == 0) {
						answer += 1;
					} else {
						answer += 2;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,answer);

		}

	}

}
