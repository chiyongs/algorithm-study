package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_7964_부먹왕국의차원관문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int[] map = new int[n+2];
			map[0] = 1;
			map[n+1] = 1;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1;i<=n;i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			int distance = 0, cnt = 0;
			for(int i=0;i<n+2;i++,distance++) {
				if(map[i]==1) {
					distance = 0;
				}
				if(distance == d) {
					distance = 0;
					map[i] = 1;
					cnt++;
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
}
