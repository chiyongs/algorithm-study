import java.util.Scanner;

public class 봉우리2_10 {
	public int solution(int n, int[][] nums) {
		int answer = 0;
		
		int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
		
		for(int r=0;r<n+2;r++) {
			for(int c=0;c<n+2;c++) {
				int count = 0;
				for(int i=0;i<4;i++) {
					int nr = r+deltas[i][0];
					int nc = c+deltas[i][1];
					
					if(0<=nr && nr<n+2 && 0<=nc && nc<n+2 && nums[r][c] != 0 && nums[r][c] > nums[nr][nc]) {
						count++;
					}
				}
				if(count == 4) {
					answer++;
				}
				count = 0;
			}
		}
		return answer;

	}

	public static void main(String[] args) {
		봉우리2_10 T = new 봉우리2_10();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] nums = new int[n+2][n+2];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				nums[i][j] = kb.nextInt();
			}
			
		}
		System.out.println(T.solution(n, nums));
	}

}
