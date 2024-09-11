package leetcode.recommendlist;

public class ExcelSheetColumnNumber171 {
    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }

        int sum = 0;
        char[] chArr = s.toUpperCase().toCharArray();
        for (int i=0;i<chArr.length;i++) {
            sum *= 26;
            sum += chArr[i] - 'A' + 1;
        }

        return sum;
    }
}
