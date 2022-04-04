package swea.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 4.
 * @see 
 * @performance 23,044 kb 135 ms
 * @category #구현 #4방탐색
 * @note
 */
public class SWEA_SAMPLE_1767_프로세서연결하기 {

	static class Core implements Comparable<Core>{
		int r, c;
		int[] dir = new int[4];

		public Core(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Core o) {
			int cnt = 0;
			int ocnt = 0;
			for(int i=0;i<4;i++) {
				if(this.dir[i]!=0) {
					cnt++;
				}
				if(o.dir[i] !=0) {
					ocnt++;
				}
			}
			return cnt - ocnt;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];

			List<Core> cores = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int val = Integer.parseInt(st.nextToken());
					if (val == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						// 테투리에 존재하는 코어들은 전선 연결이 필요없음
						cores.add(new Core(i, j));
					}
					map[i][j] = val;
				}
			}

			for (int i = 0; i < cores.size(); i++) {
				Core cur = cores.get(i);
				
				for (int d = 0; d < 4; d++) {
					int cnt = 0;
					int nr = cur.r;
					int nc = cur.c;
					while (true) {
						nr += dr[d];
						nc += dc[d];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
							break;
						}
						if(map[nr][nc] == 1) {
							cnt=0;
							break;
						}
						cnt++;
					}
					
					if(cnt!=0) {
						// 테투리에 갈 수 있으면 (전선을 연결할 수 있으면)
						cur.dir[d] = cnt;
					}
					
				}
				
			}
			
			Collections.sort(cores); // 갈 수 있는 방향이 적은 코어부터 먼저 전선연결을 시도
			
			// 갈 수 있는 방향이 없는 코어는 제거
			for(int i=0;i<cores.size();i++) {
				Core cur = cores.get(i);
				int cnt = 0;
				for(int d=0;d<4;d++) {
					if(cur.dir[d] == 0) {
						cnt++;
					}
				}
				if(cnt==4) {
					cores.remove(i);
				}
			}

			// 갈 수 있는 방향이 존재하는 코어들을 탐색
			for(int i=0;i<cores.size();i++) {
				Core cur = cores.get(i);
				
				int cnt = Integer.MAX_VALUE;
				int idx = -1;
				for(int d=0;d<4;d++) {
					int nr = cur.r;
					int nc = cur.c;
					boolean flag = true;
					
					for(int n = 0; n<cur.dir[d];n++) {
						nr += dr[d];
						nc += dc[d];
						
						if(map[nr][nc] == 0) {
							flag &= true;
						} else {
							flag = false;
						}
					}
					
					if(cur.dir[d] == 0) {
						// 갈 수 없는 방향이면 false
						flag = false;
					}
					
					nr = cur.r;
					nc = cur.c;
					if(flag) {
						// 갈 수 있는 방향에서 다른 전선과 겹친적이 없는 경우
						if(cnt > cur.dir[d]) {
							cnt = cur.dir[d];
							idx = d;
						}
					}
				}
				
				int nr = cur.r;
				int nc = cur.c;
				
				for(int c=0;c<cnt;c++) {
					nr+=dr[idx];
					nc+=dc[idx];
					
					map[nr][nc] = 2;
				}
				
			}
			
			int answer = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == 2) {
						answer++;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}

}
