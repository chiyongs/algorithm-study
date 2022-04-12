package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_9760_PokerGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int[] suites = new int[4];
			int[] ranks = new int[14];
			
			for(int i=0;i<5;i++) {
				String card = st.nextToken();
				char suite = card.charAt(0);
				if(suite == 'S') {
					suites[0]++;
				} else if(suite == 'D') {
					suites[1]++;
				} else if(suite == 'H') {
					suites[2]++;
				} else {
					suites[3]++;
				}
				char rank = card.charAt(1);
				if(rank == 'A') ranks[1]++;
				else if(rank == 'T') ranks[10]++;
				else if(rank == 'J') ranks[11]++;
				else if(rank == 'Q') ranks[12]++;
				else if(rank == 'K') ranks[13]++;
				else ranks[rank-'0']++;
			}
			
			boolean allSameSuite = false;
			for(int i=0;i<4;i++) {
				if(suites[i] == 5)  allSameSuite = true;
			}
			
			boolean isStraight = false;
			boolean isFoK = false;
			boolean isOne = false;
			boolean isTwo = false;
			boolean isThree = false;
			
			for(int i=1;i<=13;i++) {
				int cnt = 0;
				if(ranks[i] == 1) {
					for(int j=i;j<i+5;j++) {
						int tmp = j;
						if(j>13) tmp = j % 13;
						if(ranks[tmp] == 1) cnt++; 
					}
					if(cnt == 5) isStraight = true;
				}
				if(ranks[i] == 4) isFoK = true;
				else if(ranks[i] == 3) isThree = true;
				else if(ranks[i] == 2 && isOne) isTwo = true;
				else if(ranks[i] == 2) isOne = true;
			}
			
			String answer = "";
			if(allSameSuite && isStraight) answer = "Straight Flush";
			else if(isFoK) answer = "Four of a Kind";
			else if(isThree && isOne) answer = "Full House";
			else if(allSameSuite) answer = "Flush";
			else if(isStraight) answer = "Straight";
			else if(isThree) answer = "Three of a kind";
			else if(isTwo) answer = "Two pair";
			else if(isOne) answer = "One pair";
			else answer ="High card";
			
			System.out.printf("#%d %s\n",t,answer);
			
		}
	}

}
