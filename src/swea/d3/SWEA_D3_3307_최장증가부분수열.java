package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			int[] d = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				d[i] = 1;				
				for(int j=0;j<i;j++) {
					if(arr[j]<arr[i] && d[i] < d[j] + 1) {
						d[i] = d[j] + 1;
					}
				}
			}			
			Arrays.sort(d);
			sb.append("#").append(t).append(" ").append(d[N-1]).append("\n");			
		}		
		System.out.println(sb.toString());
	}
}
