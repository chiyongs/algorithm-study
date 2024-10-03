package leetcode.recommendlist;

public class CountAndSay38 {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            sb = getNext(sb);
        }
        return sb.toString();
    }

    private StringBuilder getNext(StringBuilder cur) {
        StringBuilder next = new StringBuilder();
        int len = cur.length();
        int i = 0;

        while (i < len) {
            char c = cur.charAt(i++);
            int count = 1;
            while (i < len && c == cur.charAt(i)) {
                count++;
                i++;
            }
            next.append(count).append(c);
        }

        return next;
    }
}
