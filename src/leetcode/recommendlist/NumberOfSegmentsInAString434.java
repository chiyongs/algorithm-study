package leetcode.recommendlist;

public class NumberOfSegmentsInAString434 {

    public static void main(String[] args) {
        NumberOfSegmentsInAString434 n = new NumberOfSegmentsInAString434();
//        n.countSegments("Hello, my name is John");
        n.countSegments("                ");
    }

    public int countSegments(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else {
                if (sb.isEmpty()) {
                    continue;
                }
                cnt++;
                sb = new StringBuilder();
            }
        }
        if (!sb.isEmpty()) {
            cnt++;
        }
        return cnt;
    }
}
