package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		int rowSum = 0;
		int colSum = 0;
		int dSum1 = 0;
		int dSum2 = 0;
		int r = 0, c = n - 1;
		for (int i = 0; i < n; i++) {
			dSum1 += map[i][i];
			dSum2 += map[r++][c--];
			for (int j = 0; j < n; j++) {
				rowSum += map[i][j];
				colSum += map[j][i];
			}
			if (max < rowSum)
				max = rowSum;
			if (max < colSum)
				max = colSum;
			rowSum = 0;
			colSum = 0;
		}
		int mmax = Math.max(dSum1, dSum2);
		System.out.println(Math.max(max, mmax));

	}
}
