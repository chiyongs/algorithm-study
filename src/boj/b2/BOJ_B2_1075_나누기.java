package boj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 4. 3.
 * @see https://www.acmicpc.net/problem/1075
 * @performance 11512	80
 * @category
 * @note
 */
public class BOJ_B2_1075_나누기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		int num = N / 100 * 100;
		
		for(int i=0;i<100;i++) {
			if((num+i)%F==0) {
				if(i<9) {
					System.out.println("0"+i);
				} else {
					System.out.println(i);
				}
				break;
			}
		}
	}

}
