package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_5604_구간합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			long[] arr = new long[10];
			long point = 1;
			while (a <= b) {
				while (b % 10 != 9 && a <= b) {
					calc(b, arr, point);
					b--;
				}
				if (b < a)
					break;

				while (a % 10 != 0 && a <= b) {
					calc(a, arr, point);
					a++;
				}

				a /= 10;
				b /= 10;

				for (int i = 0; i < 10; i++) {
					arr[i] += (b - a + 1) * point;
				}

				point *= 10;
			}

			long result = 0;
			for (int i = 0; i < 10; i++) {
				result += (arr[i] * i);
			}

			System.out.printf("#%d %d\n", t, result);

		}

	}

	private static void calc(long x, long[] arr, long point) {
		while (x > 0) {
			String str = String.valueOf(x);
			int num = str.charAt(str.length() - 1) - '0';
			arr[num] += point;
			x /= 10;
		}
	}

}
