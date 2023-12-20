package leetcode.recommendlist;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class ZigzagConversion6 {
    public String convert(String s, int numRows) {
        StringBuffer[] rows = new StringBuffer[numRows];
        int location = 0;

        for(int i=0;i<numRows;i++) {
            rows[i] = new StringBuffer();
        }

        while(location < s.length()) {
            for(int i=0;i<numRows && location<s.length();i++) {
                rows[i].append(s.charAt(location++));
            }
            for(int i=numRows-2;i>0 && location<s.length();i++) {
                rows[i].append(s.charAt(location++));
            }
        }

        StringBuffer result = new StringBuffer();
        for(StringBuffer row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
