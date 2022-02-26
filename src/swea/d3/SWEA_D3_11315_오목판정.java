package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chiyongs
 * @since 2022. 2. 25.
 * @see 
 * @performance 20,488 kb 122ms 
 * @category #구현
 * @note
 */

public class SWEA_D3_11315_오목판정 {
	
	static int N;
	static char[][] map;
	static int[] dr = {1,1,1,0};
	static int[] dc = {-1,0,1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			for(int i=0;i<N;i++) {
				String input = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = input.charAt(j);
				}
			}
			boolean isYes = false;
			outer:for(int i=0;i<N;i++) {				
				for(int j=0;j<N;j++) {
					if(map[i][j] == 'o') {
						for(int d=0;d<4;d++) {
							int cnt = 1;
							int nr = i + dr[d];
							int nc = j + dc[d];							
							
							while(true) {								
								if(nr<0||nc<0||nr>=N||nc>=N||map[nr][nc] != 'o') break;
								
								cnt++;
								nr = nr + dr[d];
								nc = nc + dc[d];								
							}
							
							if(cnt>=5) {
								isYes = true;
								break outer;
							}							
						}
						
					}
				}
			}
			if(isYes) {
				System.out.printf("#%d %s\n",t,"YES");
			} else System.out.printf("#%d %s\n",t,"NO");
			
		}

	}

}
