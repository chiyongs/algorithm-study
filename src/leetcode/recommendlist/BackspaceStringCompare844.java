package leetcode.recommendlist;

public class BackspaceStringCompare844 {
    public boolean backspaceCompare(String s, String t) {
        return sb(s).equals(sb(t));
    }

    private String sb(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
