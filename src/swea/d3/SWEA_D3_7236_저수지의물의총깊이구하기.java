package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 24.
 * @see 
 * @performance 18,672 kb 108 ms
 * @category #구현
 * @note
 */


public class SWEA_D3_7236_저수지의물의총깊이구하기 {
	
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			max = 0;			
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			int[][] depth = new int[N][N];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					char x = st.nextToken().charAt(0);
					map[i][j] = x;					
				}
			}			
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(map[r][c] == 'W') {
						int cnt = 0;
						boolean isSurround = true;
						for(int d=0;d<8;d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(nr<0||nc<0||nr>=N||nc>=N) continue;
							if(map[nr][nc] == 'G') continue;
							
							isSurround &= false;
							cnt++;
						}
						
						if(isSurround) {
							depth[r][c] = 1;
							cnt = 1;
						}
						else depth[r][c] = cnt;
						if(max < cnt) {
							max = cnt;
						}
					}
				}
			}			
			sb.append("#").append(t).append(" ").append(max).append("\n");		
			
		}
		System.out.println(sb.toString());
	}

}
