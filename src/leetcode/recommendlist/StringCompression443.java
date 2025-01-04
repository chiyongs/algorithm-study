package leetcode.recommendlist;

public class StringCompression443 {
    public int compress(char[] chars) {
        int left = 0;
        int right = 0;
        int answer = 0;
        while (left <= right && right < chars.length) {
            while (right < chars.length && chars[left] == chars[right]) {
                right++;
            }
            int cnt = right - left;

            chars[answer++] = chars[left];
            if (cnt > 1) {
                String cntStr = String.valueOf(cnt);
                for (char c : cntStr.toCharArray()) {
                    chars[answer++] = c;
                }
            }
            left = right;
        }
        return answer;
    }
}
