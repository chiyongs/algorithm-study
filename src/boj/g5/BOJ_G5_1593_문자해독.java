package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 5. 12.
 * @see https://www.acmicpc.net/problem/1593
 * @performance 38980	396
 * @category #문자열
 * @note 슬라이딩 윈도우, 문자열 순열
 */
public class BOJ_G5_1593_문자해독 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int g = Integer.parseInt(st.nextToken());
		int ss = Integer.parseInt(st.nextToken());

		char[] W = br.readLine().toCharArray();
		char[] S = br.readLine().toCharArray();
		
		int[] wAlpha = new int[52];
		for (int i = 0; i < W.length; i++) {
			if (Character.isUpperCase(W[i])) {
				wAlpha[W[i] - 'A']++;
			} else {
				wAlpha[W[i] - 'a'+26]++;
			}
		}

		int[] sAlpha = new int[52];
		int start = 0;
		int end = g - 1;

		for (int i = 0; i < W.length; i++) {
			if (Character.isUpperCase(S[i])) {
				sAlpha[S[i] - 'A']++;
			} else {
				sAlpha[S[i] - 'a'+26]++;
			}
		}

		int answer = 0;
		while (end < ss) {
			boolean flag = hasWord(wAlpha, sAlpha, g);

			if (flag) {
				answer++;
			}
			if (Character.isUpperCase(S[start])) {
				sAlpha[S[start++] - 'A']--;
			} else {
				sAlpha[S[start++] - 'a'+26]--;
			}
			if (end + 1 < ss) {
				if (Character.isUpperCase(S[end + 1])) {
					sAlpha[S[++end] - 'A']++;
				} else {
					sAlpha[S[++end] - 'a'+26]++;
				}
			} else
				break;

		}

		System.out.println(answer);

	}

	private static boolean hasWord(int[] wAlpha, int[] sAlpha, int g) {
		int cnt = 0;
		for (int i = 0; i < 52; i++) {
			if (wAlpha[i] != 0 && wAlpha[i] == sAlpha[i])
				cnt += wAlpha[i];
		}

		if (cnt == g)
			return true;
		else
			return false;
	}


}
