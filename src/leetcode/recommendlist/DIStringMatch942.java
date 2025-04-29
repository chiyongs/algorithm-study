package leetcode.recommendlist;

public class DIStringMatch942 {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];

        int from = 0;
        int to = result.length - 1;

        int idx = 0;

        while (idx < s.length()) {
            if (s.charAt(idx) == 'I') {
                result[idx] = from;
                from++;
            } else {
                result[idx] = to;
                to--;
            }
            idx++;
        }

        result[result.length-1] = from;
        return result;
    }
}
