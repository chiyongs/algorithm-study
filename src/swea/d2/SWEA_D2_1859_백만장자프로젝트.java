package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 23.
 * @see 
 * @performance 134,600 431
 * @category #조합
 * @note
 */

public class SWEA_D2_1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			for(int n=0;n<N;n++) {
				price[n] = Integer.parseInt(st.nextToken());			
			}
			
			long result = 0;
			int max = price[N-1];
			
			// 끝에서부터 max보다 큰 매수가인 날이 존재하면 max 업데이트
			for(int i=N-2;i>=0;i--) {
				if(price[i] < max) {
					result += max - price[i];
				} else if (price[i] > max) {
					max = price[i];
				}
			}			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());

	}

}
