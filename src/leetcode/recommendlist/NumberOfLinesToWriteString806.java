package leetcode.recommendlist;

public class NumberOfLinesToWriteString806 {
    public int[] numberOfLines(int[] widths, String s) {
        int totalWidth = 0;
        int lines = 1;
        for (char ch : s.toCharArray()) {
            int cur = widths[ch-'a'];
            if (cur + totalWidth <= 100) {
                totalWidth += cur;
            } else {
                lines++;
                totalWidth = cur;
            }
        }
        return new int[]{lines, totalWidth};
    }
}
