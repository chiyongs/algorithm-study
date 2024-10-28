package leetcode.recommendlist;

public class ShortestDistanceToACharacter821 {
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        int idx = Integer.MAX_VALUE;
        int length = s.length();
        for (int i=0;i<length;i++) {
            char target = s.charAt(i);

            if (target != c) {
                answer[i] = Math.abs(idx - i);
            } else {
                idx = i;
                answer[i] = 0;
            }
        }

        for (int i=length-1;i>=0;i--) {
            char target = s.charAt(i);

            if (target != c) {
                answer[i] = Math.min(answer[i], Math.abs(idx-i));
            } else {
                idx = i;
                answer[i] = 0;
            }
        }

        return answer;
    }
}
