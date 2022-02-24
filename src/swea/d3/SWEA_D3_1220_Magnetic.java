package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 24.
 * @see 
 * @performance 33,648kb 155ms 
 * @category #구현
 * @note
 */


public class SWEA_D3_1220_Magnetic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] table = new int[n][n];
			
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<n;j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			String[] str = new String[n];
			
			int cnt = 0;
			for(int c=0;c<n;c++) {
				str[c] = "";
				for(int r=0;r<n;r++) {
					if(table[r][c] == 0) continue;
					str[c] += String.valueOf(table[r][c]);
				}				
				
				String s = str[c];
				
				for(int i=0,size=s.length();i<size-1;i++) {
					if(s.charAt(i) == '1' && s.charAt(i+1) == '2') {
						cnt++;
						i++;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
