package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author chiyongs
 * @since 2022. 2. 27.
 * @see https://www.acmicpc.net/problem/2491
 * @performance 11524	80
 * @category #구현#IM대비문제!
 * @note
 */
public class BOJ_S4_2477_참외밭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[][] move = new int[6][2];
		int[] directions = new int[4];
		String str = "";
		
		for(int i=0;i<6;i++) {		
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			directions[dir-1]++;			
			move[i][0] = dir;
			move[i][1] = weight;
			str += dir;
		}
		
		int result = 0;
		boolean done = false;
		if(directions[0] == 2 && directions[2]==2) {
			int a=0,b=0, air =0;
			for(int i=0;i<6;i++) {
				if(str.charAt(i) == '2') a = move[i][1];
				else if(str.charAt(i) == '4') b= move[i][1];
				if((i+1) < 6 && str.charAt(i) == '1' && str.charAt(i+1) == '3' && !done) {
					air = move[i][1] * move[i+1][1];
					done = true;
				}
			}
			if(!done) {
				air = move[0][1] * move[5][1];
			}
			result = a*b - air;						
		} else if(directions[1] == 2 && directions[3] == 2) {
			int a=0,b=0, air =0;
			for(int i=0;i<6;i++) {
				if(str.charAt(i) == '1') a = move[i][1];
				else if(str.charAt(i) == '3') b= move[i][1];
				if((i+1) < 6 && str.charAt(i) == '2' && str.charAt(i+1) == '4' && !done) {
					air = move[i][1] * move[i+1][1];
					done = true;
				}
			}
			if(!done) {
				air = move[0][1] * move[5][1];
			}
			result = a*b - air;	
			
		} else if(directions[1] == 2 && directions[2] == 2) {
			int a=0,b=0, air =0;
			for(int i=0;i<6;i++) {
				if(str.charAt(i) == '1') a = move[i][1];
				else if(str.charAt(i) == '4') b= move[i][1];
				if((i+1) < 6 && str.charAt(i) == '3' && str.charAt(i+1) == '2' && !done) {
					air = move[i][1] * move[i+1][1];
					done = true;
				}
			}
			if(!done) {
				air = move[0][1] * move[5][1];
			}
			result = a*b - air;	
			
		} else if(directions[0] == 2 && directions[3] == 2) {
			int a=0,b=0, air =0;
			for(int i=0;i<6;i++) {
				if(str.charAt(i) == '2') a = move[i][1];
				else if(str.charAt(i) == '3') b= move[i][1];
				if((i+1) < 6 && str.charAt(i) == '4' && str.charAt(i+1) == '1' && !done) {
					air = move[i][1] * move[i+1][1];
					done = true;
				}
			}
			if(!done) {
				air = move[0][1] * move[5][1];
			}
			result = a*b - air;	
		}
		
		System.out.println(result*K);
	}

}

