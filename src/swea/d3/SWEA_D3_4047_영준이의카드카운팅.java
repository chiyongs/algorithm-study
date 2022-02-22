package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWEA_D3_4047_영준이의카드카운팅 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			String input = br.readLine();
			int[] counts = new int[4];
			List<String> cards = new ArrayList<>();
			boolean isError = false;
			
			sb.append("#").append(t).append(" ");
			
			for(int i=0,size=input.length();i<size;i+=3) {				
				char[] ch = {input.charAt(i), input.charAt(i+1), input.charAt(i+2)};
				String card = String.valueOf(ch);
				if(cards.contains(card)) {
					sb.append("ERROR").append("\n");
					isError = true;
					break;
				} else {
					cards.add(card);
				}
				char c = input.charAt(i);
				if(c=='S') {
					counts[0]++;
				} else if(c=='D') {
					counts[1]++;
				} else if(c=='H') {
					counts[2]++;
				} else if(c=='C') {
					counts[3]++;
				}
			}
			if(isError) continue;

			for(int i=0;i<4;i++) {
				sb.append(13-counts[i]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
