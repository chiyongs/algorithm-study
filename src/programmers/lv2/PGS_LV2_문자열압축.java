package programmers.lv2;

/**
 * @author chiyongs
 * @since 2022. 5. 12.
 * @see https://programmers.co.kr/learn/courses/30/lessons/60057
 * @performance
 * @category #문자열
 * @note 완탐
 */
public class PGS_LV2_문자열압축 {

	public int solution(String s) {
		int answer = Integer.MAX_VALUE;

		for (int i = 1; i < s.length(); i++) {
			String result = calc(s, i);
			if (answer > result.length())
				answer = result.length();
		}

		if (answer == Integer.MAX_VALUE)
			return 1;
		return answer;
	}

	private static String calc(String s, int len) {
		String result = "";

		for (int i = 0; i < s.length(); i += len) {
			if (i + len >= s.length()) {
				result += s.substring(i);
				break;
			}
			String cur = s.substring(i, i + len);

			int cnt = 1;
			for (int j = i + len; j < s.length(); j += len) {
				String comp = "";
				if (j + len >= s.length())
					comp = s.substring(j);
				else
					comp = s.substring(j, j + len);

				if (cur.equals(comp))
					cnt++;
				else
					break;
			}

			if (cnt == 1) {
				result += cur;
			} else {
				result += cnt + cur;
				i += (cnt - 1) * len;
			}

		}

		return result;

	}

}