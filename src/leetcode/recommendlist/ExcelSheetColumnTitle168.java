package leetcode.recommendlist;

public class ExcelSheetColumnTitle168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            n--;
            int num = n%26;
            n /= 26;
            sb.append((char)(num+'A'));
        }
        return sb.reverse().toString();
    }
}
