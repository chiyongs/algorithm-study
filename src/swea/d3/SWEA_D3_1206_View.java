package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 23.
 * @see 
 * @performance 22,884 124 
 * @category #조합
 * @note
 */

public class SWEA_D3_1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] buildings = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<n;i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			for(int i=2;i<n-2;i++) {
				int building = buildings[i];
				if(building > buildings[i-2] && building > buildings[i-1] && building > buildings[i+1] && building > buildings[i+2]) {
					int beforeMax = Math.max(buildings[i-2], buildings[i-1]);
					int afterMax = Math.max(buildings[i+1], buildings[i+2]);
					int max = Math.max(beforeMax, afterMax);
					result += building - max;
				}
			}			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
